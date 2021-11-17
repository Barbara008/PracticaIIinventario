package com.example.Panaderia.repositories;

import com.example.Panaderia.entities.MateriaPrima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMateriaPrima extends JpaRepository<MateriaPrima, Long> {
}