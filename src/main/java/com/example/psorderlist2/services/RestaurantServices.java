package com.example.psorderlist2.services;

import com.example.psorderlist2.dto.request.RestaurantRequest;
import com.example.psorderlist2.dto.response.RestaurantResponse;

import java.util.List;


public interface RestaurantServices {
    RestaurantResponse saveRestaurant(RestaurantRequest restaurantRequest);
    RestaurantResponse getRestaurantById(Long restaurantId);
    String deleteRestaurantById(Long id);
    List<RestaurantResponse>getAllRestaurant();
    RestaurantResponse updateRestaurant(Long id,RestaurantRequest restaurantRequest);
    String hiringEmployee(Long userId,Boolean TakeOrNot);
}
