package com.example.system.news;

import com.example.system.attachment.AttachmentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService{

    private NewsRepository newsRepository;
    private AttachmentServiceImpl attachmentServiceImpl;

    public List<News> getAllNewsEntries() {
        return newsRepository.findAllByOrderByNewsDateDesc();
    }

    public NewsEntryDto getNewsEntry(Long id) {
        var newsEntry = newsRepository.findById(id).orElseThrow(() -> new NotFoundException("Newsentry not found"));
        var attachment = "";
        if (newsEntry.getNewsImage() != null) {
            attachment = attachmentServiceImpl.getAttachmentAsBase64(newsEntry.getNewsImage().getId());
        }

        return new NewsEntryDto(
                newsEntry.getId(),
                newsEntry.getNewsTitle(),
                newsEntry.getNewsText(),
                newsEntry.getNewsDate(),
                newsEntry.getNewsAuthor(),
                attachment
        );
    }

    public News insertNewNewsEntry(NewsEntryDto newsEntryDto, Optional<MultipartFile> file) throws IOException {

        var attachment = attachmentServiceImpl.handelAttachmentUpload(file);

        if(
                newsEntryDto.getNewsAuthor() == null ||
                newsEntryDto.getNewsTitle() == null ||
                newsEntryDto.getNewsText() == null
        ) {
            throw new NotFoundException("Speichern fehlgeschlagen - Eintrag nicht vollständig");
        }

        return newsRepository.save(new News(
                newsEntryDto.getNewsDate(),
                newsEntryDto.getNewsTitle(),
                newsEntryDto.getNewsText(),
                newsEntryDto.getNewsAuthor(),
                attachment
        ));

    }

    @Override
    public News updateNewsEntry(Long newsId, NewsEntryDto newsUpdateDto, Optional<MultipartFile> file) throws IOException {
        var newsEntry = newsRepository.findById(newsId)
                .orElseThrow(() -> new NotFoundException("Kein Eintrag mit der Id " + newsId + " gefunden"));

        var attachment = attachmentServiceImpl.handelAttachmentUpload(file);

        if(
                newsUpdateDto.getNewsAuthor() == null ||
                newsUpdateDto.getNewsTitle() == null ||
                newsUpdateDto.getNewsText() == null
        ) {
            throw new NotFoundException("Speichern fehlgeschlagen - Eintrag nicht vollständig");
        }

        newsEntry.setNewsTitle(newsUpdateDto.getNewsTitle());
        newsEntry.setNewsDate(newsUpdateDto.getNewsDate());
        newsEntry.setNewsAuthor(newsUpdateDto.getNewsAuthor());
        newsEntry.setNewsText(newsUpdateDto.getNewsText());
        newsEntry.setNewsImage(attachment);

        return newsRepository.save(newsEntry);
    }

    @Override
    public void deleteNewsEntry(Long newsId) {
        var newsEntry = newsRepository.findById(newsId)
                .orElseThrow(() -> new NotFoundException("Löschen fehlgeschlagen - Eintrag mit der ID " + newsId + " nicht gefunden"));

        newsRepository.delete(newsEntry);

    }
}
