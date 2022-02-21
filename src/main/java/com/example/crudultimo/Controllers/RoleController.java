package com.example.crudultimo.Controllers;



import com.example.crudultimo.Models.Role;
import com.example.crudultimo.Repository.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private IRoleJpaRepository repoRole;

    //Create a new role
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Role role){
        return ResponseEntity.status(HttpStatus.CREATED).body(repoRole.save(role));
    }

}
