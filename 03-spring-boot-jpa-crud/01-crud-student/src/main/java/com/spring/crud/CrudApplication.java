package com.spring.crud;

import com.spring.crud.dao.StudentDAO;
import com.spring.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
		};
	}

    private void createStudent(StudentDAO studentDAO) {
	    //create the student obje
        Student student = new Student("eda","alkan","eda@spring.com");
        //save the student obje
        studentDAO.save(student);
    }
}
