package com.example.Panaderia.services;

import com.example.Panaderia.entities.Categoria;
import com.example.Panaderia.entities.MateriaPrima;
import com.example.Panaderia.repositories.RepositorioMateriaPrima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioMateriaPrima implements ServicioBase<MateriaPrima>{

    @Autowired
    private RepositorioMateriaPrima repositorioMateriaPrima;

    @Override
    @Transactional
    public List<MateriaPrima> findAll() throws Exception {
        try {
            List<MateriaPrima> entities = repositorioMateriaPrima.findAll();
            return entities;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public MateriaPrima findById(Long id) throws Exception {
        try {
            Optional<MateriaPrima> opt = repositorioMateriaPrima.findById(id);
            return opt.get();

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public MateriaPrima save(MateriaPrima entity) throws Exception {
        try {
            entity = repositorioMateriaPrima.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public MateriaPrima update(Long id, MateriaPrima entity) throws Exception {
        try {
            Optional<MateriaPrima> opt = repositorioMateriaPrima.findById(id);
            MateriaPrima materiaPrima = opt.get();
            materiaPrima = repositorioMateriaPrima.save(materiaPrima);
            return materiaPrima;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Optional<MateriaPrima> opt = this.repositorioMateriaPrima.findById(id);
            if (!opt.isEmpty()) {
                MateriaPrima materiaPrima = opt.get();
                materiaPrima.setActivo(!materiaPrima.isActivo());
                this.repositorioMateriaPrima.save(materiaPrima);
            } else {
                throw new Exception();

            }

            return true;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }
}
