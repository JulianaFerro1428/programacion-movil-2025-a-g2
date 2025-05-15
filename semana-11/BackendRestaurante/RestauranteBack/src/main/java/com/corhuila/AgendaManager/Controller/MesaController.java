package com.corhuila.AgendaManager.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.AgendaManager.Entity.Mesa;
import com.corhuila.AgendaManager.IService.IMesaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/mesa")
public class MesaController extends ABaseController<Mesa, IMesaService> {
    public MesaController(IMesaService service) {
        super(service, "Mesa");
    }
}
