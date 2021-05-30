package com.example.rentacar.repository;

import com.example.rentacar.entity.CarData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarData, Integer> {

}
