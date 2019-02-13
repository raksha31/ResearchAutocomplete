package com.sellics.research.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
@Slf4j
public class AmazonWebRequestUtil {

    private static final String AMAZON_URL = "http://completion.amazon.com/search/complete?search-alias=aps&client=amazon-search-ui&mkt=1&q=";

    public static List<String> getPopularWordsFromKey(String key) {
        List<String> elements = new ArrayList<>();

        try {
            String result = new RestTemplate().getForObject(AMAZON_URL + key, String.class);
            log.info("Requesting data for key {} ", key);
            JSONArray suggestions = new JSONArray(result).getJSONArray(1);

            for (int j = 0; j < suggestions.length(); j++) {
                elements.add(suggestions.getString(j));
            }

        } catch (JSONException e) {
            log.error("Error getting element list from Amazon");
        }
        return elements;
    }
}