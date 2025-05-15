package com.corhuila.AgendaManager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.AgendaManager.Entity.Mesa;
import com.corhuila.AgendaManager.IRepository.IBaseRepository;
import com.corhuila.AgendaManager.IRepository.IMesaRepository;
import com.corhuila.AgendaManager.IService.IMesaService;

@Service
public class MesaService extends ABaseService<Mesa> implements IMesaService {
    @Autowired
    private IMesaRepository repository;

    @Override
    protected IBaseRepository<Mesa, Long> getRepository() {
        return repository;
    }
}
