package com.example.Panaderia.services;

import com.example.Panaderia.entities.Producto;
import com.example.Panaderia.repositories.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioProducto implements ServicioBase<Producto>{

    @Autowired
    private RepositorioProducto repositorioProducto;




    @Override
    @Transactional
    public List<Producto> findAll() throws Exception {
        try {
            List<Producto> entities = repositorioProducto.findAll();
            return entities;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Producto findById(Long id) throws Exception {
        try {
            Optional<Producto> opt = repositorioProducto.findById(id);
            return opt.get();

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Producto save(Producto entity) throws Exception {
        try {
            //entity = repositorioProducto.save(entity);
            //return entity;

            Producto producto = this.repositorioProducto.save(entity);
            return producto;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto entity) throws Exception {
        try {
            Optional<Producto> opt = repositorioProducto.findById(id);
            Producto producto = opt.get();
            producto = repositorioProducto.save(producto);
            return producto;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Producto> opt = this.repositorioProducto.findById(id);
            if (!opt.isEmpty()) {
                Producto producto = opt.get();
                producto.setActivo(!producto.isActivo());
                this.repositorioProducto.save(producto);
            } else {
                throw new Exception();

            }

            return true;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }
}
