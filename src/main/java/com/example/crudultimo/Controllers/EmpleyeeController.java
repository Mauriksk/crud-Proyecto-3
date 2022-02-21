package com.example.crudultimo.Controllers;


import com.example.crudultimo.Models.Employee;
import com.example.crudultimo.Models.Role;
import com.example.crudultimo.Repository.IEmployeeJpaRepository;
import com.example.crudultimo.Repository.IProjectJpaRepository;
import com.example.crudultimo.Repository.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleado")
public class EmpleyeeController {

    @Autowired
    private IEmployeeJpaRepository employee;

    @GetMapping("buscar/{id}")
    public ResponseEntity<Employee> getEmpleadoById(@PathVariable("id") long id) {
        Optional<Employee> empleadoData = employee.findById(id);

        if (empleadoData.isPresent()) {
            return new ResponseEntity<>(empleadoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //Create a new empleado
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Employee empleado){
        return ResponseEntity.status(HttpStatus.CREATED).body(employee.save(empleado));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Employee> updateTutorial(@PathVariable("id") long id, @RequestBody Employee empleadito) {
        Optional<Employee> empleadado_ = employee.findById(id);

        if (empleadado_.isPresent()) {
            Employee empleado = empleadado_.get();
            empleado.setFirstName(empleadito.getFirstName());
            empleado.setLastName(empleadito.getLastName());
            empleado.setEmployeeid(empleadito.getEmployeeid());
            empleado.setRole(empleadito.getRole());
            return new ResponseEntity<>(employee.save(empleado), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id) {
        try {
            employee.deleteById(id);
            return new ResponseEntity<>("Empleado despedido!! ",HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/obtener")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        try {
            List<Employee> employees = new ArrayList<Employee>();
            employee.findAll().forEach(employees::add);
            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
