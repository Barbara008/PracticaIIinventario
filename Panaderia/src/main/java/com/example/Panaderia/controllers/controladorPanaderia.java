package com.example.Panaderia.controllers;

import com.example.Panaderia.entities.Producto;
import com.example.Panaderia.services.ServicioCategoria;
import com.example.Panaderia.services.ServicioMateriaPrima;
import com.example.Panaderia.services.ServicioProducto;
import com.example.Panaderia.services.ServicioSucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class controladorPanaderia {
    @Autowired
    private ServicioProducto servicioProducto;

    @Autowired
    private ServicioCategoria servicioCategoria;

    @Autowired
    private ServicioSucursal servicioSucursal;


    @GetMapping(value = "/crudProductos")
    public String crudProductos(Model model){
        try {
            List<Producto> productos = this.servicioProducto.findAll();
            model.addAttribute("productos", productos);
            return "views/crudProductos";
        }catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping(value = "/formulario/producto/{id}")
    public String formularioProductos(Model model, @PathVariable("id") long id){
        try {
            model.addAttribute("categorias", this.servicioCategoria.findAll());
            model.addAttribute("sucursales", this.servicioSucursal.findAll());


            if (id==0){
                model.addAttribute("producto", new Producto());
            }else {
                model.addAttribute("producto", this.servicioProducto.findById(id));
            }
            return "views/formulario/producto";
        }catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    //EN REVISION POR ERROR

    @PostMapping(value = "/formulario/producto/{id}")
    public String guardarProductos(@ModelAttribute ("producto") Producto producto,
                                   Model model,
                                   @PathVariable("id") long id){
        try {
            if (id==0){
                this.servicioProducto.save(producto);
            }else {
                this.servicioProducto.update(id, producto);
            }
            return "redirect:/crudProductos";
        }catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }





}
