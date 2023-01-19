package com.news.news.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewsDTO {
    @NotNull(message = "Title Can't Be Null!")
    private String title;
    @NotNull(message = "Body Can't Be Null!")
    private String body;
    @NotNull(message = "Category Name Can't Be Null!")
    private String categoryName;
}
