package com.ipn.mx.modelo.dto;


import com.ipn.mx.modelo.entidades.Categoria;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manue
 */
public class CategoriaDTO implements Serializable{
    
    private Categoria entidad;
    
    public CategoriaDTO(){
        entidad = new Categoria();
    }

    public Categoria getEntidad() {
        return entidad;
    }

    public void setEntidad(Categoria entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave: ").append(entidad.getIdCategoria()).append("\n");
        sb.append("Nombre: ").append(entidad.getNombreCategoria()).append("\n");
        sb.append("Descripcion: ").append(entidad.getDescripcionCategoria()).append("\n");
        return sb.toString();
    }
    
    
}
