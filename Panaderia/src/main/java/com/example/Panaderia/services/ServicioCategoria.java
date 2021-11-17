package com.example.Panaderia.services;

import com.example.Panaderia.entities.Categoria;
import com.example.Panaderia.repositories.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCategoria implements ServicioBase<Categoria>{

    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @Override
    @Transactional
    public List<Categoria> findAll() throws Exception {
        try {
            List<Categoria> entities = repositorioCategoria.findAll();
            return entities;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Categoria findById(Long id) throws Exception {
        try {
            Optional<Categoria> opt = repositorioCategoria.findById(id);
            return opt.get();

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Categoria save(Categoria entity) throws Exception {
        try {
            entity = repositorioCategoria.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Categoria update(Long id, Categoria entity) throws Exception {
        try {
            Optional<Categoria> opt = repositorioCategoria.findById(id);
            Categoria categoria = opt.get();
            categoria = repositorioCategoria.save(categoria);
            return categoria;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Categoria> opt = this.repositorioCategoria.findById(id);
            if (!opt.isEmpty()) {
                Categoria categoria = opt.get();
                categoria.setActivo(!categoria.isActivo());
                this.repositorioCategoria.save(categoria);
            } else {
                throw new Exception();

            }

            return true;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }
}
