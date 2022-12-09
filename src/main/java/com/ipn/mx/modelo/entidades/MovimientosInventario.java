/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import java.sql.Date;

/**
 *
 * @author manue
 */
public class MovimientosInventario {
    private int idMovimientosInventario;
    private String tipoMovimiento;
    private Date fechaMovimiento;
    private int cantidad;
    private int idProducto;
    
    public MovimientosInventario(){}

    public int getIdMovimientosInventario() {
        return idMovimientosInventario;
    }

    public void setIdMovimientosInventario(int idMovimientosInventario) {
        this.idMovimientosInventario = idMovimientosInventario;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
