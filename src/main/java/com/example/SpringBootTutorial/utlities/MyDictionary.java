package com.example.SpringBootTutorial.utlities;

import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

public class MyDictionary {
    @Value("${app.welcome.message}")
    private String welcomeMessage;

    private Map<String, String> wordMap = new HashMap<>();

    public void add(String word, String meaning) {
        wordMap.put(word, meaning);
    }

    public String getMeaning(String word) {
        return wordMap.get(word);
    }

    public String getWelcomeMsg() {
        return welcomeMessage;
    }
}