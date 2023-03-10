package com.news.news.controller;

import com.news.news.model.Response;
import com.news.news.model.dto.SelectMultipleCategoriesDTO;
import com.news.news.service.IUserService;
import com.news.news.utils.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping(path = "/category/add/{username}/{categoryName}")
    public ResponseEntity<Response> addCategoryForUser(@PathVariable(name = "username") String username,
                                                       @PathVariable(name = "categoryName") String categoryName) {
        this.userService.selectCategory(username, categoryName);
        return ResponseEntity.ok(new Response(Message.OPERATION_SUCCESSFUL, 200, null));
    }

    @PostMapping(path = "/category/multiple/{username}")
    public ResponseEntity<Response> addCategoriesForUser(@PathVariable(name = "username") String username,
                                                         @RequestBody SelectMultipleCategoriesDTO categories) {
        this.userService.selectMultipleCategoriesForUser(username, categories);
        return ResponseEntity.ok(new Response(Message.OPERATION_SUCCESSFUL, 200, null));
    }
}
