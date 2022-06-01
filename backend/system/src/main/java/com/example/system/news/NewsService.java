package com.example.system.news;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {

    private NewsRepository newsRepository;

    public List<News> getAllNewsEntries() {

        return newsRepository.findAll();
    }

}
