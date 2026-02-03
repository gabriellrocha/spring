package io.github.gabriellrocha.myapp.service;

import io.github.gabriellrocha.myapp.dao.StudentDAO;
import io.github.gabriellrocha.myapp.entity.Student;
import io.github.gabriellrocha.myapp.exception.StudentException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Transactional
    public Student createStudent(Student student) {
        studentDAO.create(student);
        return student;
    }

    public Student findStudentById(Long id) {
        return studentDAO.findById(id)
                .orElseThrow(() -> new StudentException("Student not found"));
    }

    @Transactional
    public void deleteStudentById(Long id) {
        Student student = findStudentById(id);
        studentDAO.delete(student);
    }

    public List<Student> findAllStudents() {
        return studentDAO.findAll();
    }

    @Transactional
    public Student updateStudent(Long id, Student student) {
        // update ocorre via dirty checking
        Student studentBD = findStudentById(id);
        BeanUtils.copyProperties(student, studentBD, "id");
        return studentBD;
    }
}
