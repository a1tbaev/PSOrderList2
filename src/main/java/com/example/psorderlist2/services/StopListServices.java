package com.example.psorderlist2.services;

import com.example.psorderlist2.dto.request.StopListRequest;
import com.example.psorderlist2.dto.response.StopListResponse;
import com.example.psorderlist2.exception.SaveStopListException;

import java.util.List;


public interface StopListServices {
    StopListResponse save(Long menuId, StopListRequest request) throws SaveStopListException;
    String delete(Long id);
    StopListResponse getById(Long id);
    List<StopListResponse>getAll();
    StopListResponse update(Long id,StopListRequest request);

}
