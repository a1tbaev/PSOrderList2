package com.example.psorderlist2.controller;

import com.example.psorderlist2.dto.request.SubcategoryRequest;
import com.example.psorderlist2.dto.response.SubcategoryResponse;
import com.example.psorderlist2.services.SubcategoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/restaurant/category/subcategory")
@RequiredArgsConstructor
public class SubcategoryController {
    private final SubcategoryServices subcategoryServices;

    @PostMapping("/save/{categoryId}/{menuId}")
    public SubcategoryResponse save(@PathVariable Long categoryId, @PathVariable Long menuId, @RequestBody SubcategoryRequest request) {
        return subcategoryServices.saveSubcategory(categoryId,menuId,request);
    }

    @GetMapping("/getAll/{id}")
    public List<SubcategoryResponse> getAll(@PathVariable Long id) {
        return subcategoryServices.getAll(id);
    }

    @GetMapping("/get/{id}")
    public SubcategoryResponse getById(@PathVariable Long id) {
        return subcategoryServices.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return subcategoryServices.delete(id);
    }

    @PutMapping("/update/{id}")
    public SubcategoryResponse update(@PathVariable Long id,@RequestBody SubcategoryRequest request){
        return subcategoryServices.update(id, request);
    }

    @GetMapping("/map")
    public Map<String, List<SubcategoryResponse>> map(){
        return subcategoryServices.getMap();
    }


}
