package com.mungai.springdata_jpa_course.mapper;

import com.mungai.springdata_jpa_course.dto.AuthorResponse;
import com.mungai.springdata_jpa_course.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorResponse toResponse(Author author){
        AuthorResponse response = new AuthorResponse();
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        response.setEmail(author.getEmail());
        response.setAge(author.getAge());

        return response;
    }

}
