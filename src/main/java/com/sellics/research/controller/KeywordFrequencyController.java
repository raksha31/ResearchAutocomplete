package com.sellics.research.controller;

import com.sellics.research.dto.SellicsResponseDTO;
import com.sellics.research.service.KeywordFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sellics")
public class KeywordFrequencyController {

    @Autowired
    KeywordFrequencyService keywordFrequencyService;

    @GetMapping("/keyword/frequency")
    SellicsResponseDTO generateKeywordScore(String keyword){
        return keywordFrequencyService.calculateKeywordScore(keyword);
    }
}
