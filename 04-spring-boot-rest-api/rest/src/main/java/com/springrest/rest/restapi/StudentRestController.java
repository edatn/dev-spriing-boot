package com.springrest.rest.restapi;

import com.springrest.rest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    //@PostConstruct to load the student data / only once! for each bean
    @PostConstruct
    public void studentData(){
        studentList = new ArrayList<>();
        studentList.add(new Student("nima", "patel"));
        studentList.add(new Student("dima", "rossi"));
        studentList.add(new Student("mary", "smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }

    //define /students/{studentId} /return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return studentList.get(studentId);
    }
}
