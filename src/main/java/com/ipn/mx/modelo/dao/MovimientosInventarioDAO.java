/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.MovimientosInventarioDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class MovimientosInventarioDAO {
    private static final String SQL_INSERT = 
            "insert into MovimientosInventario(tipoMovimiento,fechaMovimiento,cantidad,idProducto) values(?,?,?,?)";
    private static final String SQL_UPDATE = 
            "update MovimientosInventario set tipoMovimiento  = ?, fechaMovimiento = ?, cantidad = ?, idProducto = ? where idMovimientosInventario = ?";
    private static final String SQL_DELETE = 
            "delete from MovimientosInventario where idMovimientosInventario = ?";
    private static final String SQL_SELECT_ALL = 
            "select * from MovimientosInventario";
    private static final String SQL_SELECT = 
            "select * from MovimientosInventario where idMovimientosInventario = ?";
    private Connection con;
    
    private void obtenerConexion(){
        String usuario = "root";
        String clave = "escom";
        String driverMysql = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ejercicio1_3cm17";
        
        try{
            Class.forName(driverMysql);
            con = DriverManager.getConnection(url,usuario,clave);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void create(MovimientosInventarioDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getTipoMovimiento());
            ps.setDate(2, dto.getEntidad().getFechaMovimiento());
            ps.setInt(3, dto.getEntidad().getCantidad());
            ps.setInt(4, dto.getEntidad().getIdProducto());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void update(MovimientosInventarioDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getTipoMovimiento());
            ps.setDate(2, dto.getEntidad().getFechaMovimiento());
            ps.setInt(3, dto.getEntidad().getCantidad());
            ps.setInt(4, dto.getEntidad().getIdProducto());
            ps.setInt(5, dto.getEntidad().getIdMovimientosInventario());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void delete(MovimientosInventarioDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdMovimientosInventario());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void selectAll(MovimientosInventarioDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {                          
                System.out.println("Clave: "+rs.getInt("idMovimientosInventario") + ", Tipo movimiento: " + rs.getString("tipoMovimiento")
                + ", Fecha: " + rs.getDate("fechaMovimiento") + ", Cantidad: " + rs.getInt("cantidad") + ", Producto: " + rs.getInt("idProducto"));
            }
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void select(MovimientosInventarioDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdMovimientosInventario());
            rs = ps.executeQuery();
            rs.next();
                System.out.println("Clave: "+rs.getInt("idMovimientosInventario") + ", Tipo movimiento: " + rs.getString("tipoMovimiento")
                + ", Fecha: " + rs.getDate("fechaMovimiento") + ", Cantidad: " + rs.getInt("cantidad") + ", Producto: " + rs.getInt("idProducto"));
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
}
