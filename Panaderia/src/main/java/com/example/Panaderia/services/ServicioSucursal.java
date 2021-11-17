package com.example.Panaderia.services;

import com.example.Panaderia.entities.Sucursal;
import com.example.Panaderia.repositories.RepositorioSucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioSucursal implements ServicioBase<Sucursal>{

    @Autowired
    private RepositorioSucursal repositorioSucursal;

    @Override
    @Transactional
    public List<Sucursal> findAll() throws Exception {
        try {
            List<Sucursal> entities = repositorioSucursal.findAll();
            return entities;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Sucursal findById(Long id) throws Exception {
        try {
            Optional<Sucursal> opt = repositorioSucursal.findById(id);
            return opt.get();

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Sucursal save(Sucursal entity) throws Exception {
        try {
            entity = repositorioSucursal.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Sucursal update(Long id, Sucursal entity) throws Exception {
        try {
            Optional<Sucursal> opt = repositorioSucursal.findById(id);
            Sucursal sucursal = opt.get();
            sucursal = repositorioSucursal.save(sucursal);
            return sucursal;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Sucursal> opt = this.repositorioSucursal.findById(id);
            if (!opt.isEmpty()) {
                Sucursal sucursal = opt.get();
                sucursal.setActivo(!sucursal.isActivo());
                this.repositorioSucursal.save(sucursal);
            } else {
                throw new Exception();

            }

            return true;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }

    }
}
