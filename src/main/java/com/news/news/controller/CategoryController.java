package com.news.news.controller;

import com.news.news.model.Category;
import com.news.news.model.Response;
import com.news.news.service.ICategoryService;
import com.news.news.utils.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;

    @PostMapping(path = "/{name}")
    public ResponseEntity<Response> addCategory(@PathVariable(name = "name") String name) {
        Category result = this.categoryService.add(name);
        return ResponseEntity.ok(new Response(Message.OPERATION_SUCCESSFUL, 200, result));
    }
}
