package com.corhuila.app_movil_g2.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.app_movil_g2.Entity.ABaseEntity;

@Repository
public interface IBaseRepository<T extends ABaseEntity, ID> extends JpaRepository<T,Long> {
}