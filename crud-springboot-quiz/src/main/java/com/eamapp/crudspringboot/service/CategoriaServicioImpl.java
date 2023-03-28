package com.eamapp.crudspringboot.service;

import com.eamapp.crudspringboot.entity.Categoria;
import com.eamapp.crudspringboot.repositorie.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicioImpl implements CategoriaServicio{

    @Autowired
    private CategoriaRepositorio repositorio;
    @Override
    public List<Categoria> listarTodosLosCategorias() {

        return repositorio.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {

        return repositorio.save(categoria);
    }

    @Override
    public Categoria obtenerCategoriaPorId(int id) {

        return repositorio.findById((int) id).get();
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {

        return repositorio.save(categoria);
    }

    @Override
    public void eliminarCategoria(int id) {
        repositorio.deleteById((int) id);

    }
}