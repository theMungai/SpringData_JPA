package com.mungai.springdata_jpa_course.repository;

import com.mungai.springdata_jpa_course.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
