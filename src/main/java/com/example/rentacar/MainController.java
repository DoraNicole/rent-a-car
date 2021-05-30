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

        CarData n = new CarData();
        n.setCode(code);
        n.setBrand("Volkswagen");
        n.setModel("Polo");
        n.setNumberChairs(5);
        n.setAutomatic(false);
        n.setNrBigLuggage(0);
        n.setNrSmallLuggage(1);
        n.setLocation("Bucuresti Otopeni Aeroport");
        n.setPricePerDay(102);
        n.setAvailable(true);
        carRepository.save(n);
        return "Saved";
    }

    @CrossOrigin
    @PostMapping(path="/login", produces = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public @ResponseBody Map<String, String> loginUser (@RequestBody Map<String, String> credentials) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        UserData user = userRepository.findUserDataByEmailAndPassword(
                credentials.get("email"), credentials.get("password"));
        System.out.println(user);
        String token = jwtTokenUtil.generateToken(user);
        Map<String, String> ans = new HashMap<>();
        ans.put("token", token);
        return ans;
    }

    @CrossOrigin
    @PostMapping(path="/register") // Map ONLY POST Requests
    public @ResponseBody String registerUser (@RequestBody Map<String, String> data) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        System.out.println(data);

        UserData newUser = new UserData();
        newUser.setEmail(data.get("email"));
        newUser.setPassword(data.get("password"));
        newUser.setFirstName(data.get("first_name"));
        newUser.setLastName(data.get("last_name"));
        newUser.setOrders("");
        newUser.setPhone(data.get("phone"));
        userRepository.save(newUser);
        return "user created";
    }

    @CrossOrigin
    @GetMapping(path="/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<CarData> getAllCars() {
        // This returns a JSON or XML with the users
        return carRepository.findAll();
    }
}
