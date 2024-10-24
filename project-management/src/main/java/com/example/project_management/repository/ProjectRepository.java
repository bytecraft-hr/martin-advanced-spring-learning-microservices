package com.example.project_management.repository;

import com.example.project_management.model.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByPersonId(Long personId);
    Optional<Project> findByNameAndPersonId(String name, Integer personId);

}
