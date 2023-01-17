package com.news.news.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tb_category")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @OneToOne()
    private News news;
    @OneToMany(mappedBy = "selectedCategory", fetch = FetchType.LAZY)
    private Set<UserSelectedCategories> user;
}
