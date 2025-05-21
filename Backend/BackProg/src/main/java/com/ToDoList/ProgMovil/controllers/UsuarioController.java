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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ToDoList.ProgMovil.models.usuario;
import com.ToDoList.ProgMovil.services.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = {"https://localhost"})
@RestController
@RequestMapping("/todolist")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping("/usuarios")
    public List<usuario> index(){
        return service.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public Optional<usuario> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<usuario> save(@RequestBody usuario usuario) {
        usuario usuarioGuardado = service.save(usuario);
        return new ResponseEntity<>(usuarioGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> update(@RequestBody usuario usuario, @PathVariable Long id){
        Optional<usuario> existingUser = service.findById(id);
        if (!existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
        usuario usuarioUpdated = existingUser.get();
        usuarioUpdated.setNombres(usuario.getNombres());
        usuarioUpdated.setApellidos(usuario.getApellidos());
        usuarioUpdated.setEmail(usuario.getEmail());
        usuarioUpdated.setPhone(usuario.getPhone());
        usuarioUpdated.setContrasenia(usuario.getContrasenia());
        service.save(usuarioUpdated);
        return ResponseEntity.ok(usuarioUpdated);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody usuario usuario) {
        try {
            service.save(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String contrasenia) {
        try {
            usuario usuario = service.login(email, contrasenia);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        request.getSession().invalidate();
            return ResponseEntity.ok("Sesión cerrada exitosamente");
    }

}