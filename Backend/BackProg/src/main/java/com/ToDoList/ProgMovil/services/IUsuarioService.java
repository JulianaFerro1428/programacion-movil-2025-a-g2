package com.ToDoList.ProgMovil.services;

import java.util.List;
import java.util.Optional;

import com.ToDoList.ProgMovil.models.usuario;

public interface IUsuarioService {
    public List<usuario> findAll();

    public Optional<usuario> findById(Long id);

    public usuario save(usuario usuarios);

    public void update(usuario usuarios, Long id);

    public void delete(Long id);

    public usuario login(String email, String contrasenia);
}
