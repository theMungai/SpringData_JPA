package com.mungai.springdata_jpa_course;

import com.mungai.springdata_jpa_course.entity.Author;
import com.mungai.springdata_jpa_course.entity.Video;
import com.mungai.springdata_jpa_course.repository.AuthorRepository;
import com.mungai.springdata_jpa_course.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringdataJpaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataJpaCourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository, VideoRepository videoRepository){
		return args -> {
			/* var author = Author.builder()
					.firstName("Simon")
					.lastName("Mungai")
					.age(26)
					.email("mungai@email.com")
					.build();

			authorRepository.save(author);
			
			 */
			var  video = Video.builder()
					.length(5)
					.name("Video_abc")
					.build();

			videoRepository.save(video);
		};
	}

}
