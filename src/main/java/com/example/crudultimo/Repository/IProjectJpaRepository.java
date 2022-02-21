package com.example.crudultimo.Repository;

import com.example.crudultimo.Models.Project;

import com.example.crudultimo.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectJpaRepository extends JpaRepository<Project, Long> {
    Project findByName(String name);
    //guarda proyecto
    public Project save(Project proyecto);
}
