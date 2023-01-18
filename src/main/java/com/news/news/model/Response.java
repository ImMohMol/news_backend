package com.news.news.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    private final String message;
    private final int statusCode;
    private final Object result;
}
