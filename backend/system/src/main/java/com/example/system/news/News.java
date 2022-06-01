package com.example.system.news;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime newsDate;

    @Column(nullable = false)
    private String newsTitle;

    @Column(nullable = false)
    private String newsText;

    @Column(nullable = false)
    private String newsAuthor;

    private String newsImage;
}
