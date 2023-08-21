package com.stackroute.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController annotation is used to create
 * Restful web services using Spring MVC
 */
@RestController

/**
 * RequestMapping annotation maps
 * HTTP requests to handler methods
 */
@RequestMapping(value = "/api/v1")
public class ServiceController {

    /**
     * To get the property values
     */
    @Value("${app.message}")
    private String message;

    @GetMapping("/hello")
    public String getMessage() {
        return message;
    }
}
