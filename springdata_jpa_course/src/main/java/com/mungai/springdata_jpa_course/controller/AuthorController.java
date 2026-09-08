package com.mungai.springdata_jpa_course.controller;

import com.mungai.springdata_jpa_course.dto.AuthorResponse;
import com.mungai.springdata_jpa_course.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService service;

    @GetMapping("/find-by-first-name/{first-name}")
    public ResponseEntity<List<AuthorResponse>> getAuthorsByFirstName(@PathVariable("first-name") String firstName){
        return ResponseEntity.ok(service.getAuthorsByFirstName(firstName));
    }

    @GetMapping("/ignore-case/{first-name}")
    public ResponseEntity<List<AuthorResponse>> getAuthorsIgnoreCase(@PathVariable("first-name") String firstName){
        return ResponseEntity.ok(service.getAuthorsIgnoreCase(firstName));
    }

    @GetMapping("/containing-and-ignore-case/{first-name}")
    public ResponseEntity<List<AuthorResponse>> getAuthorsContainingAndIgnoreCase(@PathVariable("first-name") String firstName){
        return ResponseEntity.ok(service.getAuthorsContainingAndIgnoreCase(firstName));
    }

    @GetMapping("/starts-with/{first-name}")
    public ResponseEntity<List<AuthorResponse>> getAuthorsByFirstNameThatStartsWith(@PathVariable("first-name") String firstName){
        return ResponseEntity.ok(service.getAuthorsByFirstNameThatStartsWith(firstName));
    }

    @GetMapping("/ends-with/{first-name}")
    public ResponseEntity<List<AuthorResponse>> getAuthorsByFirstNameThatEndsWith(@PathVariable("first-name") String firstName){
        return ResponseEntity.ok(service.getAuthorsByFirstNameThatEndsWith(firstName));
    }
}
