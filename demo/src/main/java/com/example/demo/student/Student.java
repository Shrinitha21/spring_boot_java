package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity //This is for hibernate, Entity Annotation: @Entity tells JPA that this class is an entity.
@Table //This is for table in database
/***The @Table annotation provides a way to specify the table name, schema, catalog, unique constraints,
 and indexes for a JPA entity. It enhances the mapping between the entity class and the database table,
 allowing for detailed customization and optimization of the database schema as it relates to the entity.***/
public class Student {
    @Id //ID Annotation: @Id marks the primary key of the entity.

     /***
     The @SequenceGenerator annotation in Java is used in the context of Java Persistence API (JPA) to define a primary key generator that uses a database sequence. A sequence is a database object that generates a series of unique numbers, which can be used for primary key values.
     Key Points
     Name: The name of the sequence generator.
     Sequence Name: The name of the database sequence object.
     Initial Value: The initial value for the sequence.
     Allocation Size: The increment size for the sequence.
     ***/
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize=1
    )

    /***T
     * he @GeneratedValue annotation specifies how primary key values are generated for an entity.
     * By combining it with the @SequenceGenerator annotation, you can use a database sequence for generating primary key values.
     * Other strategies such as AUTO, IDENTITY, and TABLE offer different ways to generate primary keys, giving you flexibility
     *  based on your application's requirements and the database system you are using.
     *  ***/
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    @Transient //@Transient marks age field as non-persistent, meaning it will not be stored in the database.
    /***Key Points
     Non-persistent Fields: Fields annotated with @Transient are not mapped to any database column.
     Calculations and Logic: Useful for fields that store calculated values or temporary state needed only at runtime.
     Serialization: It’s also used to prevent fields from being serialized if the entity implements Serializable.***/
    private Integer age;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob) {
        id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getid() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
