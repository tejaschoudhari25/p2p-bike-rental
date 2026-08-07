package com.bikerental.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bikes")
public class Bike {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String model;

    private Long pricePerDay;

    private String city;
    private String available;

    public Bike() {}

    public Bike(String name, String brand, String model, Long pricePerDay, String city, String available) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.city = city;
        this.available = available;
    }
    
    public Long getId(){ return id; }
    
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getBrand(){ return brand; }
    public void setBrand(String brand){ this.brand = brand; }

    public String getModel(){ return model; }
    public void setModel(String model){ this.model = model; }

    public Long getPricePerDay(){ return pricePerDay; }
    public void setPricePerDay(Long pricePerDay){ this.pricePerDay = pricePerDay; }

    public String getCity(){ return city; }
    public void setCity(String city){ this.city = city; }

    public String getAvailable(){ return available; }
    public void setAvailable(String available){ this.available = available; }

}
