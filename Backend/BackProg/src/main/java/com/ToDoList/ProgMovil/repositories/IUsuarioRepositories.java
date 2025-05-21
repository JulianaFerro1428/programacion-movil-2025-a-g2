package com.ToDoList.ProgMovil.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ToDoList.ProgMovil.models.usuario;

public interface IUsuarioRepositories extends CrudRepository<usuario,Long>{
    
    Optional<usuario> findByEmail(String email);

}
