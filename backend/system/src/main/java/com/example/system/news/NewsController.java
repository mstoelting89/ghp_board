package com.example.system.news;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class NewsController {

    private NewsService newsService;

    @GetMapping(path = "/api/v1/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllNews() {
        return new ResponseEntity<>(newsService.getAllNewsEntries(), HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/news/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNews(@PathVariable("id") Long id) {
        return new ResponseEntity<>(newsService.getNewsEntry(id), HttpStatus.OK);
    }
}
