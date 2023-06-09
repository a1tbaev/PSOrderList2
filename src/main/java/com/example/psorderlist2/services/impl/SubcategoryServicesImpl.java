package com.example.psorderlist2.services.impl;

import com.example.psorderlist2.dto.request.SubcategoryRequest;
import com.example.psorderlist2.dto.response.SubcategoryResponse;
import com.example.psorderlist2.entity.Category;
import com.example.psorderlist2.entity.MenuItem;
import com.example.psorderlist2.entity.Subcategory;
import com.example.psorderlist2.repository.CategoryRepository;
import com.example.psorderlist2.repository.MenuItemRepository;
import com.example.psorderlist2.repository.SubcategoryRepository;
import com.example.psorderlist2.services.SubcategoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SubcategoryServicesImpl implements SubcategoryServices {
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;
    private final MenuItemRepository menuItemRepository;

    @Override
    public SubcategoryResponse saveSubcategory(Long id, Long menuId, SubcategoryRequest request) {
        if (id != null) {
            if (menuId != null) {
                if (!request.getName().isBlank()) {
                    Category category = categoryRepository.findById(id).orElseThrow();
                    MenuItem menuItem = menuItemRepository.findById(menuId).orElseThrow();
                    Subcategory subcategory = new Subcategory(request.getName());
                    subcategory.setMenuItem(menuItem);
                    subcategory.setCategory(category);
                    subcategoryRepository.save(subcategory);
                    return new SubcategoryResponse(subcategory.getId(), subcategory.getName(), subcategory.getCategory().getName());
                }
            }
        }

        return null;
    }

     @Override
    public SubcategoryResponse getById(Long id) {
        return subcategoryRepository.getByCategoryResponse(id).orElseThrow(() ->
                new NoSuchElementException(String.format
                        ("There is no SubCategory with this ID %s", id)));
    }

    @Override
    public String delete(Long id) {
        if (id != null) {
            Subcategory subcategory = subcategoryRepository.findById(id).orElseThrow(() ->
                    new NoSuchElementException(String.format
                            ("There is no SubCategory with this ID %s", id)));
            subcategoryRepository.deleteById(id);
            return String.format("Subcategory %s is deleted", subcategory.getName());
        }
        return null;
    }

    @Override
    public List<SubcategoryResponse> getAll(Long id) {
        if (id != null) {
            return subcategoryRepository.getAllOrderAndCategory(id);
        }
        return null;
    }

    @Override
    public SubcategoryResponse update(Long id, SubcategoryRequest request) {
        if (id != null) {
            Subcategory subcategory = subcategoryRepository.findById(id).orElseThrow(() ->
                    new NoSuchElementException(String.format
                            ("There is no SubCategory with this ID %s", id)));
            subcategory.setName(request.getName());
            subcategoryRepository.save(subcategory);
            return new SubcategoryResponse(subcategory.getId(), subcategory.getName(),subcategory.getName());
        }
        return null;
    }

    @Override
    public Map<String, List<SubcategoryResponse>>  getMap() {
        Map<String, List<SubcategoryResponse>> subcategoryResponseMapCollector = subcategoryRepository.getAll().stream().collect(Collectors.groupingBy(SubcategoryResponse::getCategoryName));


    return subcategoryResponseMapCollector;
    }
}
