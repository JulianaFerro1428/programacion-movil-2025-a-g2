package com.ToDoList.ProgMovil.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ToDoList.ProgMovil.models.tareas;
import com.ToDoList.ProgMovil.models.usuario;

import java.util.List;


public interface ITareasRepositories  extends CrudRepository<tareas,Long>{
    List<tareas> findByUsuario(usuario usuario);
}
