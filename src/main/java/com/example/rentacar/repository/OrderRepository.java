package com.example.rentacar.repository;

import com.example.rentacar.entity.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderData, Integer> {
}
