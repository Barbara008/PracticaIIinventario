package com.example.Panaderia.repositories;

import com.example.Panaderia.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSucursal extends JpaRepository<Sucursal, Long> {
}
