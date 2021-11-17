package com.example.Panaderia.repositories;

import com.example.Panaderia.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
}
