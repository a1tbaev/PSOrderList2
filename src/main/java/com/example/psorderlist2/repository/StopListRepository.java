package com.example.psorderlist2.repository;

import com.example.psorderlist2.dto.response.StopListResponse;
import com.example.psorderlist2.entity.StopList;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StopListRepository extends JpaRepository<StopList, Long> {
    @Query("select new peaksoft.dto.response.StopListResponse(s.id,s.reason,s.date,s.menuItem.name) from StopList  s")
    List<StopListResponse>getAll();

    @Modifying
    @Transactional
    @Query("delete from StopList sl where sl.id = ?1")
    void deleteStopList(Long id);
}