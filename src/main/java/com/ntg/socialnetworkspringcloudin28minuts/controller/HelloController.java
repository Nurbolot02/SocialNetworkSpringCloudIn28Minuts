package com.ntg.socialnetworkspringcloudin28minuts.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {
    private final MessageSource messageSource;
    @GetMapping
    public String hello(@RequestParam(required = false) String name) {
        return String.format("Hello %s!", (name != null ? name : "world"));
    }

    @GetMapping("/inter")
    public String helloInternationalization(@RequestParam(required = false) String name) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default message", locale);
    }
}
