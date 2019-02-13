package com.sellics.research.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SellicsResponseDTO {
    private String keyword;
    private Integer score;
}
