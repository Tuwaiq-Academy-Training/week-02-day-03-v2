package com.example.userdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Data
public class ApiResponse {
    private String message;
    private Integer status;
}
