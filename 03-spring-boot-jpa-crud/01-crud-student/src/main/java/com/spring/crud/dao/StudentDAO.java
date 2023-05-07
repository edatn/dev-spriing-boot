package com.spring.crud.dao;

import com.spring.crud.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findStudentById(Integer id);

    List<Student> findAllStudent();

    List<Student> findStudentByLastName(String lastName);


}
