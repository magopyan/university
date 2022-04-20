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
@Entity(name = "University")
@Table(name = "university")
public class University implements Serializable {

    ////////
    //////////////////////////////// FIELDS
    @Id
    @SequenceGenerator(
            name = "university_sequence",
            sequenceName = "university_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "university_sequence"
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


    //@Column(name = "groups")
    @OneToMany(
            mappedBy = "university",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Group> groupSet = new HashSet<>();

    //@Column(name = "teachers")
    @OneToMany(
            mappedBy = "university",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Teacher> teacherSet = new HashSet<>();

    //@Column(name = "students")
    @OneToMany(
            mappedBy = "university",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Student> studentSet = new HashSet<>();


    ////////
    //////////////////////////////// BUSINESS LOGIC
    public void addGroup(Group group) {
        groupSet.add(group);
    }

    public void addStudent(Student student) {
        studentSet.add(student);
    }

    public void addStudent(Teacher teacher) {
        teacherSet.add(teacher);
    }


    ////////
    //////////////////////////////// CONSTRUCTORS
    public University() {
    }

    public University(String name) {
        this.name = name;
    }

    public University(String name, Set<Group> groupSet, Set<Teacher> teacherSet, Set<Student> studentSet) {
        this.name = name;
        this.groupSet = groupSet;
        this.teacherSet = teacherSet;
        this.studentSet = studentSet;
    }

    public University(Long id, String name, Set<Group> groupSet, Set<Teacher> teacherSet, Set<Student> studentSet) {
        this.id = id;
        this.name = name;
        this.groupSet = groupSet;
        this.teacherSet = teacherSet;
        this.studentSet = studentSet;
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

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }

    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
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
        return "University{" + "id=" + id + ", name=" + name + ", groupSet=" + groupSet + ", teacherSet=" + teacherSet + ", studentSet=" + studentSet + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        University that = (University) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
