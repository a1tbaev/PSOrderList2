package com.example.psorderlist2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StopListRequest  {
    private String reason;
    private LocalDate date;
}
