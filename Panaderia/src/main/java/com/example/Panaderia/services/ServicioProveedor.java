package com.example.Panaderia.services;

import com.example.Panaderia.entities.Almacen;
import com.example.Panaderia.entities.Proveedor;
import com.example.Panaderia.repositories.RepositorioProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioProveedor implements ServicioBase<Proveedor>{

    @Autowired
    private RepositorioProveedor repositorioProveedor;


    @Override
    @Transactional
    public List<Proveedor> findAll() throws Exception {
        try {
            List<Proveedor> entities = repositorioProveedor.findAll();
            return entities;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Proveedor findById(Long id) throws Exception {
        try {
            Optional<Proveedor> opt = repositorioProveedor.findById(id);
            return opt.get();

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Proveedor save(Proveedor entity) throws Exception {
        try {
            entity = repositorioProveedor.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Proveedor update(Long id, Proveedor entity) throws Exception {
        try {
            Optional<Proveedor> opt = repositorioProveedor.findById(id);
            Proveedor proveedor = opt.get();
            proveedor = repositorioProveedor.save(proveedor);
            return proveedor;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Proveedor> opt = this.repositorioProveedor.findById(id);
            if (!opt.isEmpty()) {
                Proveedor proveedor = opt.get();
                proveedor.setActivo(!proveedor.isActivo());
                this.repositorioProveedor.save(proveedor);
            } else {
                throw new Exception();

            }

            return true;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }

    }
}
