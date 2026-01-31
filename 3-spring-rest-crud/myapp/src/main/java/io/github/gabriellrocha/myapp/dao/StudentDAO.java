package io.github.gabriellrocha.myapp.dao;

import io.github.gabriellrocha.myapp.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {

    void create(Student student);

    Optional<Student> findById(Long id);

    void delete(Student student);

    List<Student> findAll();
}
