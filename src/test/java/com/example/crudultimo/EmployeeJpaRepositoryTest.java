package com.example.crudultimo;


import com.example.crudultimo.Models.Employee;
import com.example.crudultimo.Repository.IEmployeeJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Esta estiqueta DataJpaTest lo que hace es que el test se centre esclusivo en la capa JPA
 * El AutoConfigureTestDataBase en replace NONE lo que hacia era que se usara la base de datos que
 * ya existia para el test, pero ahora lo cambio a EmbeddedDatabaseConnection.H2 para usar una base de
 * datos en memoria.
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeJpaRepositoryTest {
    @Autowired
    private IEmployeeJpaRepository repo;

    @Test
    public void saveEmployee(){
        Employee john = new Employee("John", "Smith", "emp123" );
        Employee claire = new Employee("Claire", "Simpson", "empl124");

        repo.save(john);
        repo.save(claire);

        repo.flush();

        assertEquals(2, repo.findAll().size());
    }
}
