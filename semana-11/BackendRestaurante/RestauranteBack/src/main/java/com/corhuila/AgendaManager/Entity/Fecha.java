package com.corhuila.AgendaManager.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "fecha")
public class Fecha extends ABaseEntity{
    @Column(name = "code", nullable = false , length = 20)
    private String code;

    @Column(name = "fecha", nullable = false , length = 20, unique = true)
    private String fecha;

    @Column(name = "hora", nullable = false , length = 50)
    private String hora;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
