package com.corhuila.AgendaManager.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mesa")
public class Mesa extends ABaseEntity{

    @Column(name = "code", nullable = false , length = 20)
    private String code;

    @Column(name = "mesa_disponible", nullable = false , length = 20, unique = true)
    private String mesaDisponible;
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesaDisponible() {
        return mesaDisponible;
    }

    public void setMesaDisponible(String mesaDisponible) {
        this.mesaDisponible = mesaDisponible;
    }
}
