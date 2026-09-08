package com.mungai.springdata_jpa_course.repository;

import com.mungai.springdata_jpa_course.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {
}
