package com.spring.crud;

import com.spring.crud.dao.StudentDAO;
import com.spring.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {


    public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
		//	createStudent(studentDAO);
			createMultipleStudent(studentDAO);
        //   readStudent(studentDAO);
         //   queryForStudents(studentDAO);
         //   queryForStudentsByLastName(studentDAO);
         //   updateStudent(studentDAO);
          //  deleteStudent(studentDAO);
          //  deleteAllStudents(studentDAO);
		};
	}

    private void deleteAllStudents(StudentDAO studentDAO) {
        int numrowdelete = studentDAO.deleteAll();
        System.out.println("delete all student : " + numrowdelete);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("delete student : " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 2;
        Student theStudent = studentDAO.findStudentById(studentId);
        theStudent.setFirstName("tan");
        studentDAO.update(theStudent);

        System.out.println("update student : " + theStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        //get List of student
        List<Student> studentList = studentDAO.findStudentByLastName("white");
        //display list of student
        for(Student theList : studentList){
            System.out.println(theList);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        //get List of student
        List<Student> studentList = studentDAO.findAllStudent();
        //display list of student
        for(Student theList : studentList){
            System.out.println(theList);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
	    //create a student obje
        Student studentForRead = new Student("skyler" ,"white","skyler@spring.com");
        //save the student
         studentDAO.save(studentForRead);
        //display id of the student
         int studentId = studentForRead.getId();
         System.out.println("ID: " + studentId);
         //use primary key
        Student s = studentDAO.findStudentById(studentId);
        System.out.println(s);
    }


    private void createMultipleStudent(StudentDAO studentDAO) {
        //create multiple student
        Student student = new Student("eda","alkan","eda@spring.com");
        Student student2 = new Student("mary","public","mary@spring.com");
        Student student3 = new Student("apple","bun","apple@spring.com");

        //save the student obje
        studentDAO.save(student);
        studentDAO.save(student2);
        studentDAO.save(student3);
        System.out.println("saving the students");
    }

    private void createStudent(StudentDAO studentDAO) {
	    //create the student obje
        Student student = new Student("harry","potter","harry@spring.com");
        //save the student obje
        studentDAO.save(student);
    }
}
