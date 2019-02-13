package com.sellics.research.service;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import com.sellics.research.dto.SellicsResponseDTO;

import java.util.List;

@Service
public interface KeywordFrequencyService {

	public SellicsResponseDTO calculateKeywordScore(String keyword);
}
