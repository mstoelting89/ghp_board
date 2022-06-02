package com.example.system.news;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {

    private NewsRepository newsRepository;

    public List<News> getAllNewsEntries() {
        return newsRepository.findAll();
    }

    public News getNewsEntry(Long id) {
        return newsRepository.findById(id).orElseThrow(() -> new NotFoundException("Newsentry not found"));
    }
}
