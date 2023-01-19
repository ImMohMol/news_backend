package com.news.news.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNewsDTO {
    private String title;
    private String body;
    private String categoryName;
    private Long numberOfVisits;
}
