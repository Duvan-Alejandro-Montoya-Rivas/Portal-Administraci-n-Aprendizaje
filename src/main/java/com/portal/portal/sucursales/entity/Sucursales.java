package com.portal.portal.sucursales.entity;

import com.portal.portal.region.entity.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "suc_sucursales")
@NoArgsConstructor
public class Sucursales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descripcion;
    @ManyToOne
    private Region region;
}