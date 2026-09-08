package com.mungai.springdata_jpa_course.dto;

import lombok.Data;

@Data
public class AuthorResponse {
    private String firstName;
    private String lastName;
    private String email;
    private int age;

}
