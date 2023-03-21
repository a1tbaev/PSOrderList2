package com.example.psorderlist2.controller;

import com.example.psorderlist2.dto.request.MenuItemRequest;
import com.example.psorderlist2.dto.response.MenuItemResponse;
import com.example.psorderlist2.services.MenuItemServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/menuItem")
@RequiredArgsConstructor
public class MenuItemController {
    private final MenuItemServices menuItemServices;
    @PostMapping("/save")
    public MenuItemResponse save(@RequestBody MenuItemRequest request){
        return menuItemServices.save(request);
    }

    @GetMapping("/get/{id}")
    public MenuItemResponse getById(@PathVariable Long id){
        return menuItemServices.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return menuItemServices.delete(id);
    }

    @GetMapping("/getAllOrder/{descOrAsc}")
    public List<MenuItemResponse> getAllOrder(@PathVariable Boolean descOrAsc){
        return menuItemServices.getAllOrder(descOrAsc);
    }

    @GetMapping("/getAllVega/{descOrAsc}")
    public List<MenuItemResponse> getAllVega(@PathVariable Boolean descOrAsc){
        return menuItemServices.getAllVega(descOrAsc);
    }

    @GetMapping("/getAllContains/{name}")
    public List<MenuItemResponse> getAllContains(@PathVariable String name) {
        return menuItemServices.getAllContains(name);
    }
}
