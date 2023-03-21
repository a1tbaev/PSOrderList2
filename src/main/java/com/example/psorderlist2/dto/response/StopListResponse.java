package com.example.psorderlist2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StopListResponse {
    private Long id;
    private String reason;
    private LocalDate date;
    private String menuItemName;
}
