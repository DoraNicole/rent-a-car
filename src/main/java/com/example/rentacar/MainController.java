package com.example.rentacar;

import com.example.rentacar.registration.JwtTokenUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller // This means that this class is a Controller
@RequestMapping(path="/rent-a-car") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;

    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public MainController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String code) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Car n = new Car();
        n.setCode(code);
        carRepository.save(n);
        return "Saved";
    }

    @CrossOrigin
    @PostMapping(path="/login", produces = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public @ResponseBody Map<String, String> loginUser (@RequestBody Map<String, String> credentials) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        System.out.println(credentials);

//        UserData newUser = new UserData();
//        newUser.setEmail("tilica_dora@yahoo.com");
//        newUser.setPassword("dora123");
//        newUser.setFirstName("dora");
//        newUser.setLastName("nico");
//        newUser.setOrders("");
//        newUser.setPhone("1234567891");
//        userRepository.save(newUser);
        UserData user = userRepository.findUserDataByEmailAndPassword(
                credentials.get("email"), credentials.get("password"));
        String token = jwtTokenUtil.generateToken(user);
        Map<String, String> ans = new HashMap<>();
        ans.put("token", token);
        return ans;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Car> getAllCars() {
        // This returns a JSON or XML with the users
        return carRepository.findAll();
    }
}