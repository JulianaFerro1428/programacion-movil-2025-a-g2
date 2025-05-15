package com.corhuila.app_movil_g2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.app_movil_g2.Entity.Continent;
import com.corhuila.app_movil_g2.IRepository.IBaseRepository;
import com.corhuila.app_movil_g2.IRepository.IContinentRepository;
import com.corhuila.app_movil_g2.IService.IContinentService;

@Service
public class ContinentService extends ABaseService<Continent> implements IContinentService {
    @Override
    protected IBaseRepository<Continent, Long> getRepository() {
        return repository;
    }
    
    @Autowired
    private IContinentRepository repository;
}