package com.sellics.research.service;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import com.sellics.research.dto.ScoreMatch;
import com.sellics.research.util.AmazonWebRequestUtil;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScoreCalculator {

    public ScoreMatch calculateScoreForString(String partialString, String inputString, ScoreMatch scoreMatch, Integer wordWeigtage) {

        List<String> elements = AmazonWebRequestUtil.getPopularWordsFromKey(partialString);

        Optional<String> presentInList = elements.stream().
                filter(i -> i.startsWith(inputString)).findFirst();

        if (presentInList.isPresent()) {
            scoreMatch.setMatch(true);
        } else {
            scoreMatch.setScore(scoreMatch.getScore() - wordWeigtage);
        }
        return scoreMatch;
    }
}