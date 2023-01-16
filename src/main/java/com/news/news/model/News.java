package com.news.news.model;

import com.news.news.model.enums.NewsCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_news")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String body;
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private NewsCategory category;
    private Long numberOfVisits = 0L;
}
