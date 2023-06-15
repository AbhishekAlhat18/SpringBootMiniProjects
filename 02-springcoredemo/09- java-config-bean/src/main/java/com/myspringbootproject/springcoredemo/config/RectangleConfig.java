package com.myspringbootproject.springcoredemo.config;

import com.myspringbootproject.springcoredemo.model.Rectangle;
import com.myspringbootproject.springcoredemo.model.Shape;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RectangleConfig {


    @Bean("aquatic")
    public Shape rectangleShape(){
        return new Rectangle();

    }
}
