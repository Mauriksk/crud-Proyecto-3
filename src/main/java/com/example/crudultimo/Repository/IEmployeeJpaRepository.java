package com.example.crudultimo.Repository;

import com.example.crudultimo.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface que extiende de JpaRepository y este es un repositorio para una tabla de tipo
 * Employee y su indentificado es de tipo Long
 */

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long> {
    // TODO: 2/18/2022 Esto lo puedo hacer con todos los campos, tener en cuenta para la tarea
    //Selecciona todos los campos de la tabla employee donde employeeid='[parametroQueLePasamos]'
    Employee findByEmployeeid(String employeeid);
}

