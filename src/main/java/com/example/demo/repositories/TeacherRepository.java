/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.entities.Teacher;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miki
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Modifying
    @Transactional
    @Query("delete from Teacher t where t.id = ?1")
    void deleteByIdd(Long id);
}
