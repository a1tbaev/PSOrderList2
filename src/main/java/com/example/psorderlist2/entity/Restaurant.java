package com.example.psorderlist2.entity;

import com.example.psorderlist2.enums.RestaurantType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
    @SequenceGenerator(name = "restaurant_seq")
    private Long id;
    private String name;
    private String location;
    @Enumerated(EnumType.STRING)
    private RestaurantType restaurantType;
    private int numberOfEmployees;
    private int services;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    public Restaurant(String name, String location, RestaurantType restaurantType, int numberOfEmployees, int services) {
        this.name = name;
        this.location = location;
        this.restaurantType = restaurantType;
        this.numberOfEmployees = numberOfEmployees;
        this.services = services;
    }

    public Restaurant() {
    }
    public void assign(User user){
        this.users.add(user);
    }
}