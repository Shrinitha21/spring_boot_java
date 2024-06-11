package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    //dependency injection, Using studentservice object in controller class
    private final StudentService  studentservice;

    //Constructor
    //studentservice object will get instantiated and injected into controller class
    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    //Function
    @GetMapping
    public List<Student> getStudents()
    {
        //calls the function of StudentService class
        return studentservice.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student)
    {

        studentservice.addNewStudent(student);

    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long id)
    {
        //calls the function of StudentService class
        studentservice.deleteStudent(id);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudent(@PathVariable ("studentID") Long Id,
                              @RequestParam (required = false) String name,
                              @RequestParam(required=false) String email)
    {
        studentservice.updateStudent(Id,name,email);
    }

}
