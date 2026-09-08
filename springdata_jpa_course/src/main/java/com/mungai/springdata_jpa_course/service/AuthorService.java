package com.mungai.springdata_jpa_course.service;

import com.mungai.springdata_jpa_course.dto.AuthorResponse;
import com.mungai.springdata_jpa_course.entity.Author;
import com.mungai.springdata_jpa_course.mapper.AuthorMapper;
import com.mungai.springdata_jpa_course.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    
    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    @Transactional
    public List<AuthorResponse> getAuthorsByFirstName(String firstName) {
        List<Author> authors = repository.findAllByFirstName(firstName);
        return authors.stream().map(mapper::toResponse).toList();
    }

    @Transactional
    public List<AuthorResponse> getAuthorsIgnoreCase(String firstName) {
        List<Author> authors = repository.findAllByFirstNameIgnoreCase(firstName);
        return authors.stream().map(mapper::toResponse).toList();
    }

    @Transactional
    public List<AuthorResponse> getAuthorsContainingAndIgnoreCase(String firstName) {
        List<Author> authors = repository.findAllByFirstNameContainingIgnoreCase(firstName);
        return authors.stream().map(mapper::toResponse).toList();
    }

    @Transactional
    public List<AuthorResponse> getAuthorsByFirstNameThatStartsWith(String firstName) {
        List<Author> authors = repository.findAllByFirstNameStartsWithIgnoreCase(firstName);
        return authors.stream().map(mapper::toResponse).toList();
    }

    @Transactional
    public List<AuthorResponse> getAuthorsByFirstNameThatEndsWith(String firstName) {
        List<Author> authors = repository.findAllByFirstNameEndsWithIgnoreCase(firstName);
        return authors.stream().map(mapper::toResponse).toList();
    }

}
