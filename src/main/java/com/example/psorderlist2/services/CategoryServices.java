package com.example.psorderlist2.services;


import com.example.psorderlist2.dto.request.CategoryRequest;
import com.example.psorderlist2.dto.response.CategoryResponse;
import com.example.psorderlist2.entity.Category;

import java.util.List;


public interface CategoryServices {
    CategoryResponse saveCategory(CategoryRequest request);
    List<CategoryResponse>getAllCategory();
    Category get(Long id);
    CategoryResponse getById(Long id);
    String deleteById(Long id);
    CategoryResponse update(Long id,CategoryRequest request);
    void saves(Category category);

}
