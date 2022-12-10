package com.ipn.mx.modelo.dao;


import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
    private static final String SQL_SELECT_BY_NAME =
            "SELECT * FROM categoria WHERE nombreCategoria = ?";
    private Connection con;
    
    private void obtenerConexion(){
        String usuario = "root";
        String clave = "root";
        String driverMysql = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/practica1";
        
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
            if(ps != null) ps.close();
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
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }
    
    public ArrayList<CategoriaDTO> selectAll() throws SQLException{
        ArrayList<CategoriaDTO> categorias = new ArrayList<>();
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {                          
                CategoriaDTO dto = new CategoriaDTO();
                dto.getEntidad().setIdCategoria((int) rs.getLong(1));
                dto.getEntidad().setNombreCategoria(rs.getString(2));
                dto.getEntidad().setDescripcionCategoria(rs.getString(3));
                categorias.add(dto);
            }
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
        if(categorias.size() > 0) return categorias;
        return null;
    }
    
    public CategoriaDTO select(CategoriaDTO dto) throws SQLException{
        CategoriaDTO dtoResultado=null;
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
            rs = ps.executeQuery();
            if(rs.next()){
                dtoResultado= new CategoriaDTO();
                dtoResultado.getEntidad().setIdCategoria((int) rs.getLong(1));
                dtoResultado.getEntidad().setNombreCategoria(rs.getString(2));
                dtoResultado.getEntidad().setDescripcionCategoria(rs.getString(3));                
            }
               
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
        return dtoResultado; 
    }
    
    public CategoriaDTO selectByName(CategoriaDTO dto) throws SQLException{
        CategoriaDTO dtoResultado=null;
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT_BY_NAME);
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            rs = ps.executeQuery();
            if(rs.next()){
                dtoResultado = new CategoriaDTO();
                dtoResultado.getEntidad().setIdCategoria(rs.getInt(1));
                dtoResultado.getEntidad().setNombreCategoria(rs.getString(2));
                dtoResultado.getEntidad().setDescripcionCategoria(rs.getString(3));                
            }
               
        }finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
        return dtoResultado;
    }
    
}
