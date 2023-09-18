package com.example.Booksdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/hello")
    public String test(){
        return "Hello, World!";
    }
}
