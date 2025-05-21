package com.ToDoList.ProgMovil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ToDoList.ProgMovil.models.usuario;
import com.ToDoList.ProgMovil.repositories.IUsuarioRepositories;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepositories repositorie;

    @Override
    @Transactional(readOnly = true)
    public List<usuario> findAll() {
        return (List<usuario>) repositorie.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<usuario> findById(Long id) {
        return repositorie.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repositorie.deleteById(id);
    }

    @Override
    @Transactional
    public usuario save(usuario usuario) {
        Optional<usuario>  existingUser = repositorie.findByEmail(usuario.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("El usuario ya esta registrado");
        }
        return repositorie.save(usuario);
    }

    @Override
    @Transactional
    public void update(usuario usuario, Long id) {
        Optional<usuario> usuarOptional = repositorie.findById(id);

        if (usuarOptional.isPresent()) {
            usuario usuarioUpdated = usuarOptional.get();
            usuarioUpdated.setNombres(usuario.getNombres());
            usuarioUpdated.setApellidos(usuario.getApellidos());
            usuarioUpdated.setEmail(usuario.getEmail());
            usuarioUpdated.setPhone(usuario.getPhone());
            usuarioUpdated.setContrasenia(usuario.getContrasenia());
            repositorie.save(usuarioUpdated);
        } else {
            System.out.println("No existe registro");
        }
    }

    @Transactional(readOnly = true)
    public usuario login(String email, String contrasenia) {
    Optional<usuario> usuarioOptional = repositorie.findByEmail(email);
    if (!usuarioOptional.isPresent()) {
        throw new RuntimeException("Correo no encontrado");
    }
    usuario usuario = usuarioOptional.get();
    
    // Verificar si la contraseña coincide
    if (!usuario.getContrasenia().equals(contrasenia)) {
        throw new RuntimeException("Contraseña incorrecta");
    }
    
    return usuario; // Si las credenciales son correctas, retornamos el usuario
}

}