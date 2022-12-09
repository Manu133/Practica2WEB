package com.ipn.mx.modelo.dao;


import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manue
 */
public class CategoriaDAO {
    private static final String SQL_INSERT = 
            "insert into Categoria(nombreCategoria, descripcionCategoria) values(?, ?)";
    private static final String SQL_UPDATE = 
            "update Categoria set nombreCategoria  = ?, descripcionCategoria = ? where idCategoria = ?";
    private static final String SQL_DELETE = 
            "delete from Categoria where idCategoria = ?";
    private static final String SQL_SELECT_ALL = 
            "select * from Categoria";
    private static final String SQL_SELECT = 
            "select * from Categoria where idCategoria = ?";
    private Connection con;
    
    private void obtenerConexion(){
        String usuario = "root";
        String clave = "escom";
        String driverMysql = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ejercicio1_3cm17";
        
        try{
            Class.forName(driverMysql);
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(CategoriaDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            ps.setString(2, dto.getEntidad().getDescripcionCategoria());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void update(CategoriaDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            ps.setString(2, dto.getEntidad().getDescripcionCategoria());
            ps.setInt(3, dto.getEntidad().getIdCategoria());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
    
    public void delete(CategoriaDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
            ps.executeUpdate();
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void selectAll(CategoriaDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {                          
                System.out.println("Id: "+rs.getInt("idCategoria") + ", Nombre categoria: " + rs.getString("nombreCategoria")
                + ", Descripcion: " + rs.getString("descripcionCategoria"));
            }
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
    
    public void select(CategoriaDTO dto) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
            rs = ps.executeQuery();
            rs.next();
                System.out.println("Clave: "+rs.getInt("idCategoria") + ", Nombre categoria: " + rs.getString("nombreCategoria")
                + ", Descripcion: " + rs.getString("descripcionCategoria"));
        }finally{
            if(ps != null) ps.close();;
            if(con != null) con.close();
        }
    }
}
