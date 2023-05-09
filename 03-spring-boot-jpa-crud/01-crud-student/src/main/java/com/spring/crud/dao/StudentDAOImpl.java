package com.spring.crud.dao;

import com.spring.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findStudentById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAllStudent() {
        //Create query for all student
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName(String lastName) {
        //create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName = : p_lastName", Student.class);
        //set query param
        query.setParameter("p_lastName",lastName);
        //results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve student
        Student deleteStudent = entityManager.find(Student.class, id);

        //delete student
        entityManager.remove(deleteStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowDeleted = entityManager.createQuery("Delete from Student").executeUpdate();
        return rowDeleted;
    }


}
