package io.github.gabriellrocha.myapp.dao;

import io.github.gabriellrocha.myapp.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastname(String lastname);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
