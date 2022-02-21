package com.example.crudultimo.Repository;

import com.example.crudultimo.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRoleJpaRepository extends JpaRepository<Role,Long>{
    Role findByName(String name);
    //guarda role
    public Role save(Role rol);

}
