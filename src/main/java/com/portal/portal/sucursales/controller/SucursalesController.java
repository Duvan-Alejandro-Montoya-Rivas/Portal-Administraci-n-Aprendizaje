package com.portal.portal.sucursales.controller;

import com.portal.portal.sucursales.entity.Sucursales;
import com.portal.portal.sucursales.service.SucursalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
public class SucursalesController {

    private final SucursalesService sucursalesService;

    @Autowired
    public SucursalesController(SucursalesService sucursalesService) {
        this.sucursalesService = sucursalesService;
    }

    @GetMapping
    public ResponseEntity<List<Sucursales>> getAllSucursales() {
        List<Sucursales> sucursales = sucursalesService.getAllSucursales();
        return new ResponseEntity<>(sucursales, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sucursales> addSucursales(@RequestBody Sucursales sucursales) {
        Sucursales createdSucursales = sucursalesService.saveSucursales(sucursales);
        return new ResponseEntity<>(createdSucursales, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursales(@PathVariable long id) {
        sucursalesService.deleteSucursales(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
