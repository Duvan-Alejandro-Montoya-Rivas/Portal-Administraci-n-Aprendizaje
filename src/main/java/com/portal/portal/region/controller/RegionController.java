package com.portal.portal.region.controller;

import com.portal.portal.region.entity.Region;
import com.portal.portal.region.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/registro")
public class RegionController {

        private final RegionService regionService;

        @Autowired
        public RegionController(RegionService regionService) {this.regionService = regionService;}

        @GetMapping
        public ResponseEntity<List<Region>> getAllRegions() {
            List<Region> regions = regionService.getAllRegions();
            return new ResponseEntity<>(regions, HttpStatus.OK);
        }
        @PostMapping
        public ResponseEntity<Region> addRegion(@RequestBody Region region) {
            Region createdRegion = regionService.saveRegion(region);
            return new ResponseEntity<>(createdRegion, HttpStatus.CREATED);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Region> deleteRegion(@PathVariable Long id) {
            regionService.deleteRegion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody Region regionDetails) {
            Region updatedRegion = regionService.updateRegion(id, regionDetails);
            if (updatedRegion != null) {
                return new ResponseEntity<>(updatedRegion, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }


}
