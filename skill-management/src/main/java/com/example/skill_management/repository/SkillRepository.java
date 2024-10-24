package com.example.skill_management.repository;



import com.example.skill_management.model.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

    Optional<Skill> findByNameAndPersonId(String name, Integer personId);
    List<Skill> findByPersonId(Long personId);

}
