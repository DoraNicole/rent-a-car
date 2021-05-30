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

  private String location;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getCarId() {
    return carId;
  }

  public void setCarId(Integer carId) {
    this.carId = carId;
  }

  public Date getPickUpDate() {
    return pickUpDate;
  }

  public void setPickUpDate(Date pickUpDate) {
    this.pickUpDate = pickUpDate;
  }

  public Date getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public boolean isConfirmed() {
    return confirmed;
  }

  public void setConfirmed(boolean confirmed) {
    this.confirmed = confirmed;
  }

  private boolean confirmed;
}
