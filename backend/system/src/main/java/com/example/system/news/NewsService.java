package com.example.system.news;

import java.util.List;

public interface NewsService {

    List<News> getAllNewsEntries();

    News getNewsEntry(Long id);

    News insertNewNewsEntry(NewsEntryDto newsEntryDto);
}
