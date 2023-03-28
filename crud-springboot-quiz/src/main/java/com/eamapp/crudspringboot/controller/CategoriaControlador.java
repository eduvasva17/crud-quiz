package com.eamapp.crudspringboot.controller;

import com.eamapp.crudspringboot.entity.Categoria;
import com.eamapp.crudspringboot.service.CategoriaServicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaControlador {
    @Autowired
    private CategoriaServicio servicio;

    @GetMapping({ "/categorias"})
    public String listarCategorias(Model modelo) {
        modelo.addAttribute("categorias", servicio.listarTodosLosCategorias());
        return "categorias"; // nos retorna al archivo categorias
    }

    @GetMapping("/categorias/nuevo")
    public String mostrarFormularioDeRegistrtarCategoria(Model modelo) {
        Categoria categoria = new Categoria();
        modelo.addAttribute("categoria", categoria);
        return "crear_categoria";
    }

    @PostMapping("/categorias")
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        servicio.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable int id, Model modelo) {
        modelo.addAttribute("categoria", servicio.obtenerCategoriaPorId(id));
        return "editar_categoria";
    }

    @PostMapping("/categorias/{id}")
    public String actualizarCategoria(@PathVariable int id, @ModelAttribute("categoria") Categoria categoria,
                                       Model modelo) {
        Categoria categoriaExistente = servicio.obtenerCategoriaPorId(id);
        categoriaExistente.setCodigo(id);
        categoriaExistente.setNombreProducto(categoria.getNombreProducto());
        categoriaExistente.setDescripcion(categoria.getDescripcion());

        servicio.actualizarCategoria(categoriaExistente);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/{id}")
    public String eliminarCategoria(@PathVariable int id) {
        servicio.eliminarCategoria(id);
        return "redirect:/categorias";
    }


}
