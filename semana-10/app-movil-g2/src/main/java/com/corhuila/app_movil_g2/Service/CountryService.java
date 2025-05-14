package com.corhuila.app_movil_g2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corhuila.app_movil_g2.Entity.Country;
import com.corhuila.app_movil_g2.IRepository.IBaseRepository;
import com.corhuila.app_movil_g2.IRepository.ICountryRepository;
import com.corhuila.app_movil_g2.IService.ICountryService;

@Service
public class CountryService extends ABaseService<Country> implements ICountryService {
    @Override
    protected IBaseRepository<Country, Long> getRepository() {
        return repository;
    }
    @Autowired
    private ICountryRepository repository;
}