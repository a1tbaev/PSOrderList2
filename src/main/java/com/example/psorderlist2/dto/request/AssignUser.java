package com.example.psorderlist2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignUser {
    private Long userId;
    private Boolean takeOrNot;
}
