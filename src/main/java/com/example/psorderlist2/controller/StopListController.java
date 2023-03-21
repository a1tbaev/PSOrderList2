package com.example.psorderlist2.controller;

import com.example.psorderlist2.dto.request.StopListRequest;
import com.example.psorderlist2.dto.response.StopListResponse;
import com.example.psorderlist2.exception.SaveStopListException;
import com.example.psorderlist2.services.StopListServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/restaurant/stopList")
@RequiredArgsConstructor
public class StopListController {
    private final StopListServices stopListServices;

    @PostMapping("/save/{menuId}")
    public StopListResponse save(@PathVariable Long menuId, @RequestBody StopListRequest request){
        try {
            return stopListServices.save(menuId,request);
        } catch (SaveStopListException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAll")
    public List<StopListResponse>getAll(){
        return stopListServices.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return stopListServices.delete(id);
    }

    @GetMapping("/get/{id}")
    public StopListResponse getById(@PathVariable Long id){
        return stopListServices.getById(id);
    }

    @PutMapping("/update/{id}")
    public StopListResponse update(@PathVariable Long id,@RequestBody StopListRequest request){
        return stopListServices.update(id, request);
    }

}
