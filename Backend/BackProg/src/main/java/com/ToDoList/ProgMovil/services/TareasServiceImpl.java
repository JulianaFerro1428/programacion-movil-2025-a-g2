package com.ToDoList.ProgMovil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ToDoList.ProgMovil.models.tareas;
import com.ToDoList.ProgMovil.models.usuario;
import com.ToDoList.ProgMovil.repositories.ITareasRepositories;
import com.ToDoList.ProgMovil.repositories.IUsuarioRepositories;

@Service
public class TareasServiceImpl implements ITareasService {

    @Autowired
    private ITareasRepositories repositorie;

    @Autowired
    private IUsuarioRepositories usuarioRepositories;

    @Override
    @Transactional(readOnly = true)
    public List<tareas> findAll() {
        return (List<tareas>) repositorie.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<tareas> findById(Long id) {
        return repositorie.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repositorie.deleteById(id);
    }

    @Override
    @Transactional
    public tareas save(tareas tarea) {
        if (tarea.getUsuario() != null && tarea.getUsuario().getId() != null) {
            // Recupera el usuario desde la base de datos
            usuario usuarioReal = usuarioRepositories.findById(tarea.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            tarea.setUsuario(usuarioReal);
        } else {
            throw new RuntimeException("La tarea no tiene un usuario válido.");
        }

        tarea.setIsFinished(false);
        return repositorie.save(tarea);
    }


    @Override
    @Transactional
    public void update(tareas tarea, Long id) {
        Optional<tareas> tareaOptional = repositorie.findById(id);

        if (tareaOptional.isPresent()) {
            tareas tareaUpdated = tareaOptional.get();
            tareaUpdated.setFullname(tarea.getFullname());
            tareaUpdated.setCategoria(tarea.getCategoria());
            tareaUpdated.setDescription(tarea.getDescription());
            tareaUpdated.setFechaCreacion(tarea.getFechaCreacion());
            repositorie.save(tareaUpdated);
        } else {
            System.out.println("No existe registro");
        }
    }

    @Override
    public List<tareas> findByUsuario(Long userId){
        Optional<usuario> userOpt = usuarioRepositories.findById(userId);
        if(userOpt.isPresent()){
            return repositorie.findByUsuario(userOpt.get());
        }
        return List.of();
    }

    @Override
    @Transactional
    public tareas tareaFinalizada(Long id){
        Optional<tareas> tareaOpt = repositorie.findById(id);
        if (tareaOpt.isPresent()) {
            tareas tarea = tareaOpt.get();
            tarea.setIsFinished(true);
            return repositorie.save(tarea);
        }
        return null;
    }
}