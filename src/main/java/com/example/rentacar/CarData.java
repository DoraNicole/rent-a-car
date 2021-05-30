package com.example.rentacar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class CarData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String code;

    private String brand;

    private String model;

    private Integer numberChairs;

    private boolean automatic;

    private Integer nrBigLuggage;

    private Integer nrSmallLuggage;

    private String location;

    private Integer pricePerDay;

    private boolean available;

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getNumberChairs() {
    return numberChairs;
  }

  public void setNumberChairs(Integer numberChairs) {
    this.numberChairs = numberChairs;
  }

  public boolean isAutomatic() {
    return automatic;
  }

  public void setAutomatic(boolean automatic) {
    this.automatic = automatic;
  }

  public Integer getNrBigLuggage() {
    return nrBigLuggage;
  }

  public void setNrBigLuggage(Integer nrBigLuggage) {
    this.nrBigLuggage = nrBigLuggage;
  }

  public Integer getNrSmallLuggage() {
    return nrSmallLuggage;
  }

  public void setNrSmallLuggage(Integer nrSmallLuggage) {
    this.nrSmallLuggage = nrSmallLuggage;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Integer getPricePerDay() {
    return pricePerDay;
  }

  public void setPricePerDay(Integer pricePerDay) {
    this.pricePerDay = pricePerDay;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
