package com.example.system.news;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class NewsController {

    private NewsService newsService;
    private NewsRepository newsRepository;

    @GetMapping(path = "/api/v1/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllNews() {

        return new ResponseEntity<>(newsService.getAllNewsEntries(), HttpStatus.OK);
    }
}
