package com.eamapp.crudspringboot.service;

import com.eamapp.crudspringboot.entity.Categoria;

import java.util.List;

public interface CategoriaServicio {
    public List<Categoria> listarTodosLosCategorias();

    public Categoria guardarCategoria(Categoria Categorias);

    public Categoria obtenerCategoriaPorId(int id);

    public Categoria actualizarCategoria(Categoria Categorias);

    public void eliminarCategoria(int id);
}
