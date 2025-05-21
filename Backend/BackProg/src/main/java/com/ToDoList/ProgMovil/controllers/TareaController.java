package com.ToDoList.ProgMovil.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ToDoList.ProgMovil.models.tareas;
import com.ToDoList.ProgMovil.services.ITareasService;

@CrossOrigin(origins = {"https://localhost"})
@RestController
@RequestMapping("/todolist")
public class TareaController {
    
    @Autowired
    private ITareasService service;

    @GetMapping("/tareas")
    public List<tareas> index(){
        return service.findAll();
    }

    @GetMapping("/tareas/{id}")
    public Optional<tareas> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/tareas")
    public ResponseEntity<?> save(@RequestBody tareas tarea) {
        try {
            tareas tareaGuardada = service.save(tarea);
            return new ResponseEntity<>(tareaGuardada, HttpStatus.CREATED);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


    @PutMapping("/tareas/{id}")
    public ResponseEntity<?> update(@RequestBody tareas tareas, @PathVariable Long id){
        Optional<tareas> existingUser = service.findById(id);
        if (!existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tareas no encontrado");
        }
        tareas tareasUpdated = existingUser.get();
        tareasUpdated.setFullname(tareas.getFullname());
        tareasUpdated.setCategoria(tareas.getCategoria());
        tareasUpdated.setDescription(tareas.getDescription());
        tareasUpdated.setFechaCreacion(tareas.getFechaCreacion());
        service.save(tareasUpdated);
        return ResponseEntity.ok(tareasUpdated);
    }

    @DeleteMapping("/tareas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/usuarios/{id}/tareas")
    public ResponseEntity<List<tareas>> getTareasByUsuario(@PathVariable Long id){
        List<tareas> tareas = service.findByUsuario(id);
        return ResponseEntity.ok(tareas);
    }

    @PutMapping("tareas/{id}/finalizar")
    public ResponseEntity<tareas> marcarTareaFinalizada(@PathVariable Long id) {
        tareas tarea = service.tareaFinalizada(id);
        if(tarea != null){
            return ResponseEntity.ok(tarea);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
