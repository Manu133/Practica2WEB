/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author manue
 */
public class EditCategoria extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	int idCategoria = Integer.parseInt(id);
	CategoriaDAO dao = new CategoriaDAO();
	CategoriaDTO dto1 = new CategoriaDTO();
	dto1.getEntidad().setIdCategoria(idCategoria);
	CategoriaDTO dto2 = dao.select(dto1);
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>\n" +
"\n" +
"        <title>Start Page</title>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n" +
"        <script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n" +
"        <script type=\"text/javascript\" src=\"js/jquery-3.6.1.min.js\"> </script>   \n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    </head>");
            out.println("<body class=\"p-3 m-0 border-0 bd-example\">\n" +
"    <!-- Example Code -->\n" +
"    <div>\n" +
"      <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n" +
"        <div class=\"container-fluid\">\n" +
"          <a class=\"navbar-brand\" href=\"#\">Practica 1 </a>\n" +
"          <button\n" +
"            class=\"navbar-toggler\"\n" +
"            type=\"button\"\n" +
"            data-bs-toggle=\"collapse\"\n" +
"            data-bs-target=\"#navbarNav\"\n" +
"            aria-controls=\"navbarNav\"\n" +
"            aria-expanded=\"false\"\n" +
"            aria-label=\"Toggle navigation\"\n" +
"          >\n" +
"            <span class=\"navbar-toggler-icon\"></span>\n" +
"          </button>\n" +
"          <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n" +
"            <ul class=\"navbar-nav\">\n" +
"              <li class=\"nav-item\">\n" +
"                <a\n" +
"                  class=\"nav-link active\"\n" +
"                  aria-current=\"page\"\n" +
"                  href=\"CategoriaServ\"\n" +
"                  >Categorias</a\n" +
"                >\n" +
"              </li>\n" +
"              <li class=\"nav-item\">\n" +
"                <a class=\"nav-link active\" href=\"ProductoServ\">Productos</a>\n" +
"              </li>\n" +
"            </ul>\n" +
"          </div>\n" +
"        </div>\n" +
"      </nav>\n" +
"    </div>\n");
            out.println("<div class=\"container\">\n" +
"      <div class=\"row pt-2\">\n" +
"        <div class=\"mb-3\">\n" +
"          <a class=\"btn btn-dark w-100\" href=\"javascript: history.go(-1)\"\n" +
"            >Regresar</a\n" +
"          >\n" +
"        </div>\n" +
"      </div>\n" +
"    </div>");
            out.println("<div class=\"container\">\n" +
"      <div class=\"row pt-2\">\n" +
"        <div class=\"card text-white bg-dark\">\n" +
"          <div class=\"card-header text-center\">Actualizar Categoria</div>\n" +
"          <div class=\"card-body\">\n" +
"            <form action=\"Actualizada\" method=\"POST\">\n" );
out.println("              <div class=\"mb-3\"> <label>Id Categoria</label></div>\n");
out.println("              <div class=\"mb-3\"><input class=\"form-control\" type=\"text\" name=\"idCat\" value=\""+ dto1.getEntidad().getIdCategoria() +"\"></div>\n" +
"              <div class=\"mb-3\"> " );
out.println("              <div class=\"mb-3\"> <label>Nombre Producto</label></div>\n");
out.println("              <div class=\"mb-3\"><input class=\"form-control\" type=\"text\" name=\"nombreCat\" value=\""+ dto2.getEntidad().getNombreCategoria() +"\"></div>\n" +
"              <div class=\"mb-3\"> <label>Descripción</label></div>\n" );
out.println("              <div class=\"mb-3\"><input class=\"form-control\" type=\"text\" name=\"descCat\" value=\""+ dto2.getEntidad().getDescripcionCategoria() +"\"></div>\n" );
            
out.println("</select></div>               <div class=\"mb-3\"><button class=\"btn btn-secondary w-100\" type=\"submint\" >Actualizar</button> </div>\n" +
"            </form>\n" +
"            \n" +
"          </div>\n" +
"      </div>\n" +
"    </div>");
out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
