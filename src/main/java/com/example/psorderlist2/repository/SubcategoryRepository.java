package com.example.psorderlist2.repository;

import com.example.psorderlist2.dto.response.SubcategoryResponse;
import com.example.psorderlist2.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    @Query("select new peaksoft.dto.response.SubcategoryResponse(c.id,c.name,c.category.name) from Subcategory c where c.id=?1")
    Optional<SubcategoryResponse> getByCategoryResponse(Long id);
    @Query("select new peaksoft.dto.response.SubcategoryResponse(c.id,c.name,c.category.name) from Subcategory c where c.category.id=?1")
    List<SubcategoryResponse> getAllOrderAndCategory(Long id);

    @Query("select new peaksoft.dto.response.SubcategoryResponse(c.id,c.name,c.category.name) from Subcategory c")
    List<SubcategoryResponse> getAll();
}