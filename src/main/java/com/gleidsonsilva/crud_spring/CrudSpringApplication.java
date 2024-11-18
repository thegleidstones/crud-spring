package com.gleidsonsilva.crud_spring;

import com.gleidsonsilva.crud_spring.enums.Category;
import com.gleidsonsilva.crud_spring.model.Course;
import com.gleidsonsilva.crud_spring.model.Lesson;
import com.gleidsonsilva.crud_spring.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			for (int i = 0; i < 20; i++) {
				Course c = new Course();
				c.setName("Angular com Spring " + i);
				c.setCategory(Category.FRONT_END);

				Lesson l = new Lesson();
				l.setName("Introdução ao Angular " + i);
				l.setLessonUrl("https://youtube.com/456321987aaa44s5");
				l.setCourse(c);
				c.getLessons().add(l);

				Lesson l1 = new Lesson();
				l1.setName("Aula 01 " + i);
				l1.setLessonUrl("https://youtube.com/456321987aaa44s5");
				l1.setCourse(c);
				c.getLessons().add(l1);

				courseRepository.save(c);
			}
		};
	}

}
