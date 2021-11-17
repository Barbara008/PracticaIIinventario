package com.example.Panaderia.services;

import com.example.Panaderia.entities.Almacen;
import com.example.Panaderia.repositories.RepositorioAlmacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioAlmacen implements ServicioBase<Almacen>{

    @Autowired
    private RepositorioAlmacen repositorioAlmacen;

    @Override
    @Transactional
    public List<Almacen> findAll() throws Exception {
        try {
            List<Almacen> entities = repositorioAlmacen.findAll();
            return entities;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Almacen findById(Long id) throws Exception {
        try {
            Optional<Almacen> opt = repositorioAlmacen.findById(id);
            return opt.get();

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Almacen save(Almacen entity) throws Exception {
        try {
            entity = repositorioAlmacen.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Almacen update(Long id, Almacen entity) throws Exception {
        try {
            Optional<Almacen> opt = repositorioAlmacen.findById(id);
            Almacen almacen = opt.get();
            almacen = repositorioAlmacen.save(almacen);
            return almacen;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Almacen> opt = this.repositorioAlmacen.findById(id);
            if (!opt.isEmpty()) {
                Almacen almacen = opt.get();
                almacen.setActivo(!almacen.isActivo());
                this.repositorioAlmacen.save(almacen);
            } else {
                throw new Exception();

            }

            return true;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }

    }
}
