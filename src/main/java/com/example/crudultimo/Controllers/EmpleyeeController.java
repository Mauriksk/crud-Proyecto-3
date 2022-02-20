package com.example.crudultimo.Controllers;


import com.example.crudultimo.Models.Employee;
import com.example.crudultimo.Repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empleado")
public class EmpleyeeController {

    @Autowired
    private IEmployeeJpaRepository employee;

    //Create a new empleado
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Employee empleado){
        return ResponseEntity.status(HttpStatus.CREATED).body(employee.save(empleado));
    }


}
