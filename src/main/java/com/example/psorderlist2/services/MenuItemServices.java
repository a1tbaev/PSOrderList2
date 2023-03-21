package com.example.psorderlist2.services;

import com.example.psorderlist2.dto.request.MenuItemRequest;
import com.example.psorderlist2.dto.response.MenuItemResponse;

import java.util.List;


public interface MenuItemServices {
    MenuItemResponse save(MenuItemRequest request);
    MenuItemResponse update(Long id,MenuItemRequest request);
    MenuItemResponse getById(Long id);
    String delete(Long id);
    List<MenuItemResponse>getAllOrder(Boolean descOrAsc);
    List<MenuItemResponse>getAllVega(Boolean vegOrNot);
    List<MenuItemResponse>getAllContains(String name);

}
