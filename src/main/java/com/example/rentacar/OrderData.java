package com.example.rentacar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class OrderData {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  private Integer userId;

  private Integer carId;

  private Date pickUpDate;

  private Date returnDate;

  private Integer price;

  private boolean confirmed;
}
