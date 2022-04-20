/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * @author Miki
 */
@Entity(name = "Group")
@Table(name = "grupa")
public class Group implements Serializable {

    ////////
    //////////////////////////////// FIELDS
    @Id
    @SequenceGenerator(
            name = "group_sequence",
            sequenceName = "group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "group_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    //    @Column(
//	    name = "teacher",
//	    nullable = false
//    )
    @ManyToOne
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Teacher teacher;

    //@Column(name = "students")
    @OneToMany(
            mappedBy = "group",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Student> studentSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(
            name = "university_id",
            referencedColumnName = "id",
            nullable = false
    )
    private University university;


    ////////
    //////////////////////////////// CONSTRUCTORS
    public void addStudent(Student student) {
        studentSet.add(student);
    }


    ////////
    //////////////////////////////// CONSTRUCTORS
    public Group() {
    }

    public Group(String name, Teacher teacher, University university) {
        this.name = name;
        this.teacher = teacher;
        this.university = university;
    }
    public Group(String name, Teacher teacher, Set<Student> studentSet, University university) {
        this.name = name;
        this.teacher = teacher;
        this.studentSet = studentSet;
        this.university = university;
    }

    public Group(Long id, String name, Teacher teacher, Set<Student> studentSet, University university) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.studentSet = studentSet;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }


    ////////
    //////////////////////////////// TOSTRING, EQUALS, HASHCODE


    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher.getFirstName() + teacher.getLastName() +
                ", studentSet=" + studentSet.size() + " students" +
                ", university=" + university.getName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return id.equals(group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
