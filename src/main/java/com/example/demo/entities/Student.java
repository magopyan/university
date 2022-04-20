/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Miki
 */
@Entity(name = "Student")
@Table(name = "student")
public class Student implements Serializable {

    ////////
    //////////////////////////////// FIELDS
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "grade",
            nullable = false
    )
    private Double grade;

    @ManyToOne
    @JoinColumn(
            name = "group_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Group group;

    @ManyToOne
    @JoinColumn(
            name = "university_id",
            referencedColumnName = "id",
            nullable = false
    )
    private University university;


    ////////
    //////////////////////////////// CONSTRUCTORS
    public Student() {
    }

    public Student(String firstName, String lastName, Double grade, Group group, University university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.group = group;
        this.university = university;
    }

    public Student(Long id, String firstName, String lastName, Double grade, Group group, University university) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.group = group;
        this.university = university;
    }

    ////////
    //////////////////////////////// GETTERS, SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }


    ////////
    //////////////////////////////// TOSTRING, EQUALS, HASCODE
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
