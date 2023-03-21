package com.example.psorderlist2.controller;

import com.example.psorderlist2.dto.request.CategoryRequest;
import com.example.psorderlist2.dto.response.CategoryResponse;
import com.example.psorderlist2.services.CategoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/restaurant/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServices categoryServices;

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public CategoryResponse save(@RequestBody CategoryRequest request){
        return categoryServices.saveCategory(request);
    }

    @PostMapping("/getAll")
    public List<CategoryResponse>getAll(){
        return categoryServices.getAllCategory();
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return categoryServices.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public CategoryResponse getBiId(@PathVariable Long id){
        return categoryServices.getById(id);
    }

    @PutMapping("/update/{id}")
    public CategoryResponse update(@PathVariable Long id,@RequestBody CategoryRequest request){
        return categoryServices.update(id,request);
    }

}
