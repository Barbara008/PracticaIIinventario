package com.example.Panaderia.repositories;

import com.example.Panaderia.entities.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAlmacen extends JpaRepository<Almacen, Long> {
}