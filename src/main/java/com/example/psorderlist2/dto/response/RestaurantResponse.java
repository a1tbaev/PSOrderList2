package com.example.psorderlist2.dto.response;

import com.example.psorderlist2.enums.RestaurantType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponse {
    private Long id;
    private String name;
    private String location;
    private RestaurantType restaurantType;
    private int numberOfEmployees;
    private int services;
}
