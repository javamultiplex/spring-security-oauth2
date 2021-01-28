package com.javamultiplex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rohit Agarwal on 28/01/21 2:22 pm
 * @copyright www.javamultiplex.com
 */
//@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
