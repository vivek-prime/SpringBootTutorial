package com.example.SpringBootTutorial.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("db")
@Data
public class DbConfig {
    private String connection;
    private String host;
    private Integer port;
}
