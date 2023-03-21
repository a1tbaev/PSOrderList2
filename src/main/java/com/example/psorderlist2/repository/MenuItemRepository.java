package com.example.psorderlist2.repository;

import com.example.psorderlist2.dto.response.MenuItemResponse;
import com.example.psorderlist2.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    @Query("select new peaksoft.dto.response.MenuItemResponse(m.id,m.name,m.image,m.price,m.description,m.isVegetarian) from MenuItem m where m.id=?1")
    Optional<MenuItemResponse> getByMenu(Long id);
    @Query("select new peaksoft.dto.response.MenuItemResponse(m.id,m.name,m.image,m.price,m.description,m.isVegetarian) from MenuItem m")
    List<MenuItemResponse>getAllOrder();
}