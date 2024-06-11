package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration //a class-level annotation indicating that an object is a source of bean definitions
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository) {
        return args -> {

                Student Shrinitha =  new Student(
                           "Shrinitha",
                           "shrinitha@gmail.com",
                           LocalDate.of(1999, Month.JUNE,21)


                   );
            Student Megha= new Student(
                    "Megha",
                    "megha@gmail.com",
                    LocalDate.of(2002, Month.AUGUST,21)


            );

                   repository.saveAll(List.of(Shrinitha,Megha));
        };


    }

}
/***Purpose of CommandLineRunner
 Initialization Tasks: It is often used for performing tasks that need to run once the application context is fully set up, such as loading initial data into the database or starting background tasks.

 Simple Syntax: Implementing CommandLineRunner is straightforward and allows you to quickly add startup logic without the need for a separate configuration.***/