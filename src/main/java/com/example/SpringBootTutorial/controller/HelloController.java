package com.example.SpringBootTutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Value("${app.welcome.message}")
    String welcomeMessage;

    @Value("${app.list.values}")
    List<String> listValues;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String helloWorld(){
        return welcomeMessage + " - " + listValues;
    }

}
