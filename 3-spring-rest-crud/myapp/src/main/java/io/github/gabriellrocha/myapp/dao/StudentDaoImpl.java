package io.github.gabriellrocha.myapp.dao;

import io.github.gabriellrocha.myapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDAO {

    private final EntityManager entityManager;

    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        Student student = entityManager.find(Student.class, id);

        return Optional.ofNullable(student);
    }

    @Override
    public void delete(Student student) {
        entityManager.remove(student);
    }

    @Override
    public List<Student> findAll() {

        String jpql = "SELECT s FROM Student s";

        TypedQuery<Student> typedQuery = entityManager.createQuery(jpql, Student.class);

        return typedQuery.getResultList();
    }
}
