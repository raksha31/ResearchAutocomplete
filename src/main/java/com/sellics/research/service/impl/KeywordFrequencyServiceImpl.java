package com.sellics.research.service.impl;

import com.sellics.research.dto.ScoreMatch;
import com.sellics.research.dto.SellicsResponseDTO;
import com.sellics.research.service.KeywordFrequencyService;
import com.sellics.research.service.ScoreCalculator;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class KeywordFrequencyServiceImpl implements KeywordFrequencyService {

    @Autowired
    private ScoreCalculator scoreCalculator;

    @Override
    public SellicsResponseDTO calculateKeywordScore(String inputString) {
        if (StringUtils.isBlank(inputString))
            return new SellicsResponseDTO(inputString, 0);

        String partialString = "";
        Integer wordWeigtage = 100 / inputString.length();
        ScoreMatch scoreMatch = new ScoreMatch(100, false);

        for (int i = 0; i < inputString.length(); i++) {
            partialString += inputString.charAt(i);
            scoreMatch = scoreCalculator.calculateScoreForString(partialString, inputString.toLowerCase(), scoreMatch, wordWeigtage);
            if (scoreMatch.getMatch()) {
                return new SellicsResponseDTO(inputString, scoreMatch.getScore());
            }
        }
        return new SellicsResponseDTO(inputString, 0);
    }

}