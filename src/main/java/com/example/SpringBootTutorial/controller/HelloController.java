package com.example.SpringBootTutorial.controller;

import com.example.SpringBootTutorial.config.DbConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class HelloController {
    @Value("${app.welcome.message}")
    String welcomeMessage;

    @Value("${app.list.values}")
    List<String> listValues;

    @Autowired
    private DbConfig dbConfig;

    @GetMapping(value = "/")
    public String helloWorld() {
        log.info("dbconfig - {}", dbConfig);
        return welcomeMessage + " - " + listValues;
    }

    @GetMapping("/getList")
    public String getList(@RequestParam List<String> ids) {
        return "IDS are - " + ids;
    }
}
