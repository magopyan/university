/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * @author Miki
 */
@Entity(name = "Teacher")
@Table(name = "teacher"/*, schema = "uni_schema"*/)
public class Teacher implements Serializable {

    ////////
    //////////////////////////////// FIELDS
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "teacher_sequence"
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

    //@Column(name = "groups")
    @OneToMany(
            mappedBy = "teacher",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Group> groupSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(
            name = "university_id",
            referencedColumnName = "id",
            nullable = false
    )
    private University university;


    ////////
    //////////////////////////////// BUSINESS LOGIC
    public void addGroup(Group group) {
        groupSet.add(group);
    }


    ////////
    //////////////////////////////// CONSTRUCTORS
    public Teacher() {
    }

    public Teacher(String firstName, String lastName, University university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
    }

    public Teacher(String firstName, String lastName, Set<Group> groupSet, University university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupSet = groupSet;
        this.university = university;
    }

    public Teacher(Long id, String firstName, String lastName, Set<Group> groupSet, University university) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupSet = groupSet;
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

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }


    ////////
    //////////////////////////////// TOSTRING, EQUALS, HASHCODE
    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", groupSet=" + groupSet + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return id.equals(teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
