package com.portal.portal.region.service;

import com.portal.portal.region.entity.Region;
import com.portal.portal.region.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            return regionRepository.findById(id)
                    .map(region -> {
                        region.setEstado(regionDetails.getEstado());
                        region.setDescripcion(regionDetails.getDescripcion());
                        region.setEstado(regionDetails.getEstado());
                        return regionRepository.save(region);
                    })
                    .orElse(null);
        }

}


