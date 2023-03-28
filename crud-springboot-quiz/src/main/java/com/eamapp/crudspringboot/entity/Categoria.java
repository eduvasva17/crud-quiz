package com.eamapp.crudspringboot.entity;

import org.springframework.beans.factory.annotation.Autowired;


import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id 
    //@Column(name="id",updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(name = "nombreProducto",nullable = false,length = 100)
    private String nombreProducto;

    @Column(name = "descripcion",nullable = false,length = 500)
    private String descripcion;

    public Categoria() {
    }

    public Categoria(int codigo, String nombreProducto, String descripcion) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    
}
