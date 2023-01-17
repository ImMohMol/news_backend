package com.news.news.model;

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
    @OneToOne()
    @JoinColumn(unique = true, nullable = false)
    private Category category;
    private Long numberOfVisits = 0L;
}
