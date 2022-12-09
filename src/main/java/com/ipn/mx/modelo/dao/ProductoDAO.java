/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ProductoDTO;
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
public class ProductoDAO {
    private static final String SQL_INSERT = 
            "insert into producto(nombreProducto,descripcionProducto,precio,existencia,idCategoria) values(?,?,?,?,?)";
    private static final String SQL_UPDATE = 
            "update producto set nombreProducto  = ?, descripcionProducto = ?, precio = ?, existencia = ?, idCategoria = ? where idProducto = ?";
    private static final String SQL_DELETE = 
            "delete from producto where idProducto = ?";
    private static final String SQL_SELECT_ALL = 
            "select * from producto";
    private static final String SQL_SELECT = 
            "select * from producto where idProducto = ?";
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
    
    public void create(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreProducto());
            ps.setString(2, dto.getEntidad().getDescripcionProducto());
            ps.setInt(3, dto.getEntidad().getPrecio());
            ps.setInt(4, dto.getEntidad().getExistencia());
            ps.setInt(5, dto.getEntidad().getIdCategoria());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void update(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreProducto());
            ps.setString(2, dto.getEntidad().getDescripcionProducto());
            ps.setInt(3, dto.getEntidad().getPrecio());
            ps.setInt(4, dto.getEntidad().getExistencia());
            ps.setInt(5, dto.getEntidad().getIdCategoria());
            ps.setInt(6, dto.getEntidad().getIdProducto());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void delete(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdProducto());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void selectAll(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {                          
                System.out.println("Clave: "+rs.getInt("idProducto") + ", Nombre: " + rs.getString("nombreProducto")
                + ", Descripcion: " + rs.getString("descripcionProducto") + ", Precio: " + rs.getInt("precio") + ", Existencia: " + rs.getInt("existencia") 
                + ", Categoria: " + rs.getInt("idCategoria"));
            }
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void select(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdProducto());
            rs = ps.executeQuery();
            rs.next();
                System.out.println("Clave: "+rs.getInt("idProducto") + ", Nombre: " + rs.getString("nombreProducto")
                + ", Descripcion: " + rs.getString("descripcionProducto") + ", Precio: " + rs.getInt("precio") + ", Existencia: " + rs.getInt("existencia") 
                + ", Categoria: " + rs.getInt("idCategoria"));
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
}
