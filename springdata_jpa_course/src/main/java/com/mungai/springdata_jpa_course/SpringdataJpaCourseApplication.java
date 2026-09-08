package com.mungai.springdata_jpa_course;

import com.github.javafaker.Faker;
import com.mungai.springdata_jpa_course.entity.Author;
import com.mungai.springdata_jpa_course.repository.AuthorRepository;
import com.mungai.springdata_jpa_course.repository.VideoRepository;
import com.mungai.springdata_jpa_course.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class SpringdataJpaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataJpaCourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository, VideoRepository videoRepository){
		return args -> {
			for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 63))
						.email(faker.name().username() + i + "@email.com")
						.build();

				//authorRepository.save(author);
			}

			// Update author with ID = 1
			var author = Author.builder()
					.id(1L)
					.firstName("Simon")
					.lastName("Mungai")
					.email("mungai@email.com")
					.age(26)
					.build();
//			authorRepository.save(author);


			// update Author a set a.age = 22 where a.id = 1
			authorRepository.updateAuthor(22, 1);


			// update all  authors' ages
			//authorRepository.updateAllAuthorsAges(99);

//			var  video = Video.builder()
//					.length(5)
//					.name("Video_abc")
//					.build();
//
//			videoRepository.save(video);





			// NamedQueries
			//authorRepository.findByNamedQuery(40).forEach(System.out::println);


			// Specification Queries
			Specification<Author> specification = Specification
					.where(AuthorSpecification.hasAge(47));
					//.and(AuthorSpecification.firstNameLike("Ke"));

			authorRepository.findAll(specification).forEach(System.out::println);
		};
	}

}
