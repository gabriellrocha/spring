package io.github.gabriellrocha.myapp.dao;

import io.github.gabriellrocha.myapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    // inject entity manager using constructor injection
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
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        // create a JPQL(based on entities and attributes).. independent of the database
        // the provider(hibernate) translates in into SQL for the target database

        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student", Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Student> findByLastname(String lastname) {

        // Named Parameters

        TypedQuery<Student> typedQuery = entityManager
                .createQuery("FROM Student WHERE lastName = :lastname", Student.class);

        typedQuery.setParameter("lastname", lastname);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {

        return entityManager
                .createQuery("DELETE FROM Student")
                .executeUpdate();
    }
}
