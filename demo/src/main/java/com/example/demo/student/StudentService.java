package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


//StudentService is a class that has to be instantiated, ie it has to be a spring Bean. This purpose below annotation is used
@Service
public class StudentService {

    private final StudentRepository studentrepository;

    @Autowired
    public StudentService(StudentRepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    public List<Student> getStudents()
    {
        return studentrepository.findAll();

    }

    public void addNewStudent(Student student)
    {
        Optional<Student> studentOptional=studentrepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent())
        {
            throw new IllegalStateException("Email Taken");
        }
        studentrepository.save(student);

    }

   public void deleteStudent(Long studentId)
    {
       boolean exists =  studentrepository.existsById(studentId);
       if (!exists){
           throw new IllegalStateException("ID does not exist");
       }
       studentrepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long Id,
                              String name,
                              String email)
    {
       Student student = studentrepository.findById(Id).orElseThrow(() ->new IllegalStateException("Id not present"));

       if (name != null && !name.isEmpty() && !Objects.equals(student.getName(), name)){
           student.setName(name);

       }
        if (email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)){
            Optional<Student> optionalStudent = studentrepository.findStudentByEmail(email);
            if(optionalStudent.isPresent()){
                throw new IllegalStateException("Email exixts");
            }
            student.setEmail(email);

        }


    }

}
