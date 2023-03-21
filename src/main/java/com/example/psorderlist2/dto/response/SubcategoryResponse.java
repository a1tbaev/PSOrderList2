package com.example.psorderlist2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubcategoryResponse {
    private Long id;
    private String name;
    private String categoryName;
}
