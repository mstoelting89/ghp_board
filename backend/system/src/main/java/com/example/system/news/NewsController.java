package com.example.system.news;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin
public class NewsController {

    @GetMapping(path = "/api/v1/news")
    public String news() {
        return "FooBar";
    }
}
