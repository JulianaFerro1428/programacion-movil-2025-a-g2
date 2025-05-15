package com.corhuila.AgendaManager.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.AgendaManager.Entity.Cliente;
import com.corhuila.AgendaManager.IRepository.IBaseRepository;
import com.corhuila.AgendaManager.IRepository.IClienteRepository;
import com.corhuila.AgendaManager.IService.IClienteService;

@Service
public class ClienteService extends ABaseService<Cliente> implements IClienteService {
    @Autowired
    private IClienteRepository repository;
    
    @Override
    protected IBaseRepository<Cliente, Long> getRepository() {
        return repository;
    }
}
