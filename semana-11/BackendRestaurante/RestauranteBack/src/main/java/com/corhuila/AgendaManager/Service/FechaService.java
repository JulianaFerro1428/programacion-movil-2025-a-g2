package com.corhuila.AgendaManager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.AgendaManager.Entity.Fecha;
import com.corhuila.AgendaManager.IRepository.IBaseRepository;
import com.corhuila.AgendaManager.IRepository.IFechaRepository;
import com.corhuila.AgendaManager.IService.IFechaService;

@Service
public class FechaService extends ABaseService<Fecha> implements IFechaService {
    @Autowired
    private IFechaRepository repository;

    @Override
    protected IBaseRepository<Fecha, Long> getRepository() {
        return repository;
    }
}
