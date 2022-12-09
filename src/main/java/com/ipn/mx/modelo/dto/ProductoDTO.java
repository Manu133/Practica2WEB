/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Producto;

/**
 *
 * @author manue
 */
public class ProductoDTO {
    private Producto entidad;
    
    public ProductoDTO(){
        entidad = new Producto();
    }

    public Producto getEntidad() {
        return entidad;
    }

    public void setEntidad(Producto entidad) {
        this.entidad = entidad;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave: ").append(entidad.getIdProducto()).append("\n");
        sb.append("Nombre: ").append(entidad.getNombreProducto()).append("\n");
        sb.append("Descripcion: ").append(entidad.getDescripcionProducto()).append("\n");
        sb.append("Precio: ").append(entidad.getPrecio()).append("\n");
        sb.append("Existencia: ").append(entidad.getExistencia()).append("\n");
        sb.append("Categoria: ").append(entidad.getIdCategoria()).append("\n");
        return sb.toString();
    } 
    
}
