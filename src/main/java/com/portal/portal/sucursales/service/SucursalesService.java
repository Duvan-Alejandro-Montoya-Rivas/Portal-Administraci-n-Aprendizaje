package com.portal.portal.sucursales.service;

import com.portal.portal.sucursales.entity.Sucursales;
import com.portal.portal.sucursales.repository.SucursalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
SucursalesService {
    private final SucursalesRepository sucursalesRepository;
    @Autowired
    public SucursalesService(SucursalesRepository sucursalesRepository) {
        this.sucursalesRepository = sucursalesRepository;
    }
    public Sucursales saveSucursales(Sucursales sucursales){
        return sucursalesRepository.save(sucursales);
    }
    public List<Sucursales> getAllSucursales(){
        return sucursalesRepository.findAll();
    }
    public void deleteSucursales(long id) {
        sucursalesRepository.deleteById(id);
    }
    public Sucursales updateSucursales(long id, Sucursales sucursalesDetails) {
       Optional<Sucursales> optionalSucursales = sucursalesRepository.findById(id);
       if (optionalSucursales.isPresent()) {
           Sucursales sucursalesExistente = optionalSucursales.get();
           if(sucursalesDetails.getDescripcion() != null){
               sucursalesExistente.setDescripcion(sucursalesDetails.getDescripcion());
           } else if (sucursalesDetails.getRegion() != null) {
               sucursalesExistente.setRegion(sucursalesDetails.getRegion());
           }
           return sucursalesRepository.save(sucursalesExistente);
       } else{
           throw new IllegalStateException("Sucursal no encontrado");
       }
    }

}
