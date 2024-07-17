package com.portal.portal.region.service;

import com.portal.portal.region.entity.Region;
import com.portal.portal.region.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
        private final RegionRepository regionRepository;
        @Autowired
        public RegionService(RegionRepository regionRepository) {
            this.regionRepository = regionRepository;
        }
        public Region saveRegion(Region region) {return regionRepository.save(region);}
        public List<Region> getAllRegions() {return regionRepository.findAll();}
        public void deleteRegion(Long id) {regionRepository.deleteById(id);}
        public Region updateRegion(Long id, Region regionDetails) {
            Optional<Region> region = regionRepository.findById(id);
            if (region.isPresent()) {
                Region regionExistente = region.get();
                if (regionDetails.getDescripcion() != null) {
                    regionExistente.setDescripcion(regionDetails.getDescripcion());
                }else if (regionDetails.getEstado() != regionExistente.getEstado()) {
                    regionExistente.setEstado(regionDetails.getEstado());
                }
                return regionRepository.save(regionExistente);


            }else {
                throw new IllegalStateException("No se puede eliminar el region");
            }

        }
}


