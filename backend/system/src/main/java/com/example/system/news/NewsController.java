package com.example.system.news;

import com.example.system.security.jwt.JwtAuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
@CrossOrigin
public class NewsController {

    private NewsService newsService;
    private JwtAuthenticationService jwtAuthenticationService;

    @GetMapping(path = "/api/v1/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllNews(HttpServletRequest request) {
        return new ResponseEntity<>(newsService.getAllNewsEntries(), HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/news/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNews(@PathVariable("id") Long id, HttpServletRequest request) {
        return new ResponseEntity<>(newsService.getNewsEntry(id), HttpStatus.OK);
    }

    // Post -> receive a new NewsEntry
    @PostMapping(path = "/api/v1/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNews(@RequestBody NewsEntryDto newsEntryDto, HttpServletRequest request) {

        return new ResponseEntity<>(newsService.insertNewNewsEntry(newsEntryDto), HttpStatus.OK);
    }

    //Put -> update an existing NewsEntry

    //Delete -> delete an existing NewsEntry

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
