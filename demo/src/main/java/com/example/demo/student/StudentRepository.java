package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository//this interface is responsible for data access

public interface StudentRepository extends JpaRepository<Student, Long>
//<T, ID> T stands for Type of object this repository to work with and ID for the type that we want
{
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    //Using Optional<Student> to handle the result of a repository query is a common practice in modern Java development,
        // especially with frameworks like Spring Data JPA. This helps to avoid null pointer exceptions and provides a
        // more functional approach to handling the absence of values.
    Optional<Student> findStudentByEmail(String email);
}

//Custom function, to find student by email.

