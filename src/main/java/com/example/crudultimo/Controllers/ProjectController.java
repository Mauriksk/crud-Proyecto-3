package com.example.crudultimo.Controllers;


import com.example.crudultimo.Models.Project;
import com.example.crudultimo.Models.Role;
import com.example.crudultimo.Repository.IProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proyecto")
public class ProjectController {
    @Autowired
    private IProjectJpaRepository repoProj;

    //Create a new proyecto
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Project proyecto){
        return ResponseEntity.status(HttpStatus.CREATED).body(repoProj.save(proyecto));
    }
}
