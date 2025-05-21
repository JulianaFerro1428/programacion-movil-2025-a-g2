package com.ToDoList.ProgMovil.models;

import java.io.Serializable;
import java.time.LocalDate;


import jakarta.persistence.Table;
import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name="Tarea")
public class tareas implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @Column(nullable = false,name="Id_Tarea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fullname",length = 100)
    private String fullname;
    
    @Column(name="description",length = 100)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, name="category")
    private categoria categoria;

    @Column(name="fechaCreacion")
    private LocalDate fechaCreacion;
    
    @Column(name = "isFinished")
    private Boolean isFinished=false;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private usuario usuario;

    public Long getId() {
        return id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }
}
