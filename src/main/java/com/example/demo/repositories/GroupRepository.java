/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.entities.Group;
import javax.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miki
 */
@Repository
@Primary
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Modifying
    @Transactional
    @Query("delete from Group g where g.id = ?1")
    void deleteByIdd(Long id);
}
