package com.ToDoList.ProgMovil.services;

import java.util.List;
import java.util.Optional;

import com.ToDoList.ProgMovil.models.tareas;

public interface ITareasService {
    public List<tareas> findAll();

    public Optional<tareas> findById(Long id);

    public tareas save(tareas tareas);

    public void update(tareas tarea, Long id);

    public void delete(Long id);

    List<tareas> findByUsuario(Long userId);

    public tareas tareaFinalizada(Long id);
}
