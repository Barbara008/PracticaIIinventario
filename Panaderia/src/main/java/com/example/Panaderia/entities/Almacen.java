package com.example.Panaderia.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "almacen")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;

    private int numeracion;

    private boolean activo = true;

    @OneToMany(mappedBy = "almacen")
    private List<MateriaPrima> materiaPrima;

}
