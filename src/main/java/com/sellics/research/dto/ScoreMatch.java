package com.sellics.research.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreMatch {
    private Integer score;
    private Boolean match;
}
