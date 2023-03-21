package com.example.psorderlist2.services;

import com.example.psorderlist2.dto.request.SubcategoryRequest;
import com.example.psorderlist2.dto.response.SubcategoryResponse;

import java.util.List;
import java.util.Map;


public interface SubcategoryServices {
    SubcategoryResponse saveSubcategory(Long id, Long menuId, SubcategoryRequest request);
    SubcategoryResponse getById(Long id);
    String delete(Long id);
    List<SubcategoryResponse>getAll(Long id);
    SubcategoryResponse update(Long id,SubcategoryRequest request);
    Map<String, List<SubcategoryResponse>> getMap();

}
