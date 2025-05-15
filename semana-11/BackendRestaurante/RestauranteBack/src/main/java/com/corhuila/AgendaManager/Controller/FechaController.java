package com.corhuila.AgendaManager.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.AgendaManager.Entity.Fecha;
import com.corhuila.AgendaManager.IService.IFechaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/fecha")
public class FechaController extends ABaseController<Fecha, IFechaService> {
    public FechaController(IFechaService service) {
        super(service, "Fecha");
    }
}
