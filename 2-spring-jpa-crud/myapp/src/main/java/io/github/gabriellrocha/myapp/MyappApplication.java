package io.github.gabriellrocha.myapp;

import io.github.gabriellrocha.myapp.dao.StudentDAO;
import io.github.gabriellrocha.myapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {

//            createStudent(studentDAO);
//            readStudent(studentDAO);
//            queryForStudent(studentDAO);
//            queryForStudentByLastname(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
            deleteAllStudents(studentDAO);
        };

    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating student...");
        Student student = new Student("Gabriel", "Silva", "gabriel@email.com");

        // save the student
        System.out.println("Saving student...");
        studentDAO.save(student);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());
    }

    private void readStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating student...");
        Student student = new Student("Maria", "Santos", "maria@email.com");

        // save the student
        System.out.println("Saving student...");
        studentDAO.save(student);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + student.getId());
        Student myStudent = studentDAO.findById(student.getId());

        System.out.println("Found student: " + myStudent);
    }

    private void queryForStudent(StudentDAO studentDAO) {

        // get list of students...
        studentDAO.findAll()
                .forEach(System.out::println);
    }

    private void queryForStudentByLastname(StudentDAO studentDAO) {

        studentDAO.findByLastname("Silva")
                .forEach(System.out::println);
    }

    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student student = studentDAO.findById(studentId);

        System.out.println("Updating student...");
        // change first name and email
        student.setFirstName("gabriel");
        student.setEmail("gabriel@gmail.com");
        studentDAO.update(student);

        // display updated student
        System.out.println("Updated Student: " + student);

    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 2;
        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting all students...");
        int numRowsAffected = studentDAO.deleteAll();
        System.out.println("Number of rows affected: " + numRowsAffected);
    }
}
