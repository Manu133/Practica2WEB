/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.MovimientosInventario;

/**
 *
 * @author manue
 */
public class MovimientosInventarioDTO {
    private MovimientosInventario entidad;
    
    public MovimientosInventarioDTO(){
        entidad = new MovimientosInventario();
    }

    public MovimientosInventario getEntidad() {
        return entidad;
    }

    public void setEntidad(MovimientosInventario entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave: ").append(entidad.getIdMovimientosInventario()).append("\n");
        sb.append("Tipo Movimiento: ").append(entidad.getTipoMovimiento()).append("\n");
        sb.append("Fecha Movimiento: ").append(entidad.getFechaMovimiento()).append("\n");
        sb.append("Cantidad: ").append(entidad.getCantidad()).append("\n");
        sb.append("Producto: ").append(entidad.getIdProducto()).append("\n");
        return sb.toString();
    }   
}
