/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.entities.University;
import com.example.demo.repositories.GroupRepository;
import com.example.demo.repositories.TeacherRepository;
import com.example.demo.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.example.demo.repositories.StudentRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miki
 */
@Component
public class UniConfig implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private UniversityRepository universityRepository;
	@Autowired
	private TeacherRepository teacherRepository;

//    @Bean
//	CommandLineRunner commandLineRunner(
//    		StudentRepository studentRepository,
//			GroupRepository groupRepository,
//			TeacherRepository teacherRepository,
//			UniversityRepository universityRepository
//	) {
//		return args -> {
//			University university = new University("TU-Varna");
//			universityRepository.save(university);
//
//			Teacher teacher1 = new Teacher("Ivelin", "Dimitrov", university);
//			Teacher teacher2 = new Teacher("Milena", "Vasileva", university);
//			teacherRepository.save(teacher1);
//			teacherRepository.save(teacher2);
//
//			Group group1 = new Group("Group 1", teacher1, university);
//			Group group2 = new Group("Group 2", teacher2, university);
//			Group group3 = new Group("Group 3", teacher2, university);
//			groupRepository.save(group1);
//			groupRepository.save(group2);
//			groupRepository.save(group3);
//
//			Student student1 = new Student("Mihael", "Agopyan", 5.25, group1, university);
//			Student student2 = new Student("Ivan", "Ivanov", 4.63, group1, university);
//			Student student3 = new Student("Anna", "Yaneva", 4.14, group2, university);
//			Student student4 = new Student("Simeon", "Velkov", 3.18, group3, university);
//			studentRepository.save(student1);
//			studentRepository.save(student2);
//			studentRepository.save(student3);
//			studentRepository.save(student4);
////
////			System.out.println(universityRepository.getById(1L).getGroupSet());
//
////			Set<Group> groupSet = new HashSet<>(List.of(group1, group2, group3));
////			university.setGroupSet(groupSet);
////			Set<Teacher> teacherSet = new HashSet<>(List.of(teacher1, teacher2));
////			university.setTeacherSet(teacherSet);
////			Set<Student> studentSet = new HashSet<>(List.of(student1, student2, student3));
////			university.setStudentSet(studentSet);
////			universityRepository.save(university);
////
////			teacher1.addGroup(group1);
////			teacher2.setGroupSet(new HashSet<>(List.of(group2, group3)));
////			teacherRepository.saveAll(List.of(teacher1, teacher2));
////
////			group1.setStudentSet(new HashSet<>(List.of(student1, student2)));
////			group2.addStudent(student3);
////			group3.addStudent(student4);
////			groupRepository.saveAll(List.of(group1, group2, group3));
////
////			studentRepository.saveAll(List.of(student1, student2, student3, student4));
//		};
//    }

	@Override
	public void run(String... args) throws Exception {

		University university = new University("TU-Varna");
		universityRepository.save(university);
//
//		Teacher teacher1 = new Teacher("Ivelin", "Dimitrov", university);
//		Teacher teacher2 = new Teacher("Milena", "Vasileva", university);
//		teacherRepository.save(teacher1);
//		teacherRepository.save(teacher2);
//
//		Group group1 = new Group("Group 1", teacher1, university);
//		Group group2 = new Group("Group 2", teacher2, university);
//		Group group3 = new Group("Group 3", teacher2, university);
//		groupRepository.save(group1);
//		groupRepository.save(group2);
//		groupRepository.save(group3);
//
//		Student student1 = new Student("Mihael", "Agopyan", 5.25, group1, university);
//		Student student2 = new Student("Ivan", "Ivanov", 4.63, group1, university);
//		Student student3 = new Student("Anna", "Yaneva", 4.14, group2, university);
//		Student student4 = new Student("Simeon", "Velkov", 3.18, group3, university);
//		studentRepository.save(student1);
//		studentRepository.save(student2);
//		studentRepository.save(student3);
//		studentRepository.save(student4);
	}
}
