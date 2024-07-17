package com.portal.portal.sucursales.repository;

import com.portal.portal.sucursales.entity.Sucursales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalesRepository extends JpaRepository<Sucursales, Long > {
}
