package com.example.psorderlist2.services.impl;

import com.example.psorderlist2.dto.request.StopListRequest;
import com.example.psorderlist2.dto.response.StopListResponse;
import com.example.psorderlist2.entity.MenuItem;
import com.example.psorderlist2.entity.StopList;
import com.example.psorderlist2.exception.SaveStopListException;
import com.example.psorderlist2.repository.MenuItemRepository;
import com.example.psorderlist2.repository.StopListRepository;
import com.example.psorderlist2.services.StopListServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
@RequiredArgsConstructor
public class StopListServicesImpl implements StopListServices {
    private final StopListRepository stopListRepository;
    private final MenuItemRepository menuItemRepository;

    @Override
    public StopListResponse save(Long menuId, StopListRequest request) throws SaveStopListException {
        MenuItem menuItem = menuItemRepository.findById(menuId).orElseThrow(() ->
                new NoSuchElementException(String.format("Menu Item with id :%s already exists!", menuId)));
        for (StopList stopList : stopListRepository.findAll()) {
            int date = stopList.getDate().compareTo(request.getDate());
            if (date==0) {
                if(stopList.getMenuItem().getId()==menuItem.getId()) {
                        throw new SaveStopListException("Save Date Exception!");
                }
            }
        }
        StopList stopList = new StopList(
                request.getReason(),
                request.getDate()
        );
        stopList.setMenuItem(menuItem);
        stopListRepository.save(stopList);
        return new StopListResponse(
                stopList.getId(),
                stopList.getReason(),
                stopList.getDate(),
                stopList.getMenuItem().getName()
        );
    }

    @Override
    public String delete(Long id) {
        StopList stopList = stopListRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException(String.format("StopList with id :%s already exists", id)));
        stopListRepository.deleteStopList(id);
        return id+ " is deleted!!!";
    }

    @Override
    public StopListResponse getById(Long id) {
        if (id != null) {
            StopList stopList = stopListRepository.findById(id).orElseThrow(() ->
                    new NoSuchElementException(String.format("StopList with id :%s already exists", id)));
            return new StopListResponse(
                    stopList.getId(),
                    stopList.getReason(),
                    stopList.getDate(),
                    stopList.getMenuItem().getName()
            );
        }
        return null;
    }

    @Override
    public List<StopListResponse> getAll() {
        return stopListRepository.getAll();
    }

    @Override
    public StopListResponse update(Long id, StopListRequest request) {
        if (id != null) {
            StopList stopList = stopListRepository.findById(id).orElseThrow(() ->
                    new NoSuchElementException(String.format("StopList with id :%s already exists", id)));
            stopList.setReason(request.getReason());
            stopList.setDate(request.getDate());
            stopListRepository.save(stopList);
            return new StopListResponse(
                    stopList.getId(),
                    stopList.getReason(),
                    stopList.getDate(),
                    stopList.getMenuItem().getName()
            );
        }
        return null;
    }


}
