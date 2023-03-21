package com.example.psorderlist2.dto.request;

import com.example.psorderlist2.enums.RestaurantType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RestaurantRequest {
    private String name;
    private String location;
    private RestaurantType restaurantType;
    private int services;
}
