package com.news.news.controller;

import com.news.news.model.News;
import com.news.news.model.Response;
import com.news.news.model.dto.CreateNewsDTO;
import com.news.news.model.dto.UpdateNewsDTO;
import com.news.news.service.INewsService;
import com.news.news.utils.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final INewsService newsService;

    @GetMapping("/")
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(new Response(Message.OPERATION_SUCCESSFUL, 200, this.newsService.getAll()));
    }

    @PostMapping("/")
    public ResponseEntity<Response> add(@RequestBody CreateNewsDTO createNewsDTO) {
        News news = this.newsService.add(createNewsDTO);
        return ResponseEntity.ok(new Response(Message.OPERATION_SUCCESSFUL, 200, news));
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Response> delete(@PathVariable(name = "title") String title) {
        News news = this.newsService.delete(title);
        return ResponseEntity.ok(new Response(Message.OPERATION_SUCCESSFUL, 200, news));
    }

    @PutMapping("/")
    public ResponseEntity<Response> update(@RequestBody UpdateNewsDTO updateNewsDTO) {
        return ResponseEntity.ok(new Response(Message.OPERATION_SUCCESSFUL, 200, null));
    }
}
