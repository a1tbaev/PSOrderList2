package com.example.psorderlist2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemResponse {
    private Long id;
    private String name;
    private String image;
    private int price;
    private String description;
    private Boolean isVegetarian;
}
