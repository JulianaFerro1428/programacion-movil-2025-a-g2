package com.corhuila.app_movil_g2.IRepository;

import org.springframework.stereotype.Repository;
import com.corhuila.app_movil_g2.Entity.Country;

@Repository
public interface ICountryRepository extends IBaseRepository<Country, Long>{

}