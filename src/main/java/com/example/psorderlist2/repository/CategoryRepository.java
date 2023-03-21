package com.example.psorderlist2.repository;

import com.example.psorderlist2.dto.response.CategoryResponse;
import com.example.psorderlist2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select new peaksoft.dto.response.CategoryResponse(c.id,c.name) from Category c")
    List<CategoryResponse> getAllCategory();

    @Query("select new peaksoft.dto.response.CategoryResponse(c.id,c.name) from Category c where c.id=?1")
    Optional<CategoryResponse> getByIdCategory(Long id);
}