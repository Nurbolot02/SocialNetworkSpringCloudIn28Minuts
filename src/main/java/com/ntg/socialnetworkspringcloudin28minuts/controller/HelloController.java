package com.ntg.socialnetworkspringcloudin28minuts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String hello(@RequestParam(required = false) String name) {
        return String.format("Hello %s!", (name != null ? name : "world"));
    }
}
