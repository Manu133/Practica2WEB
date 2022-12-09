/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ipn.mx.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author manue
 */
public class ProductoServ extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
"    </div>\n" +
"    <div class=\"container\">\n" +
"      <div class=\"row pt-2\">\n" +
"        <div class=\"mb-3\">\n" +
"          <h2 class=\"text-center\">Productos</h2>\n" +
"        </div>\n" +
"        <div class=\"mb-3\">\n" +
"          <a class=\"btn btn-dark w-100\" href=\"AddProducto\">Añadir Producto</a>\n" +
"        </div>\n" +
"        <table class=\"table table-dark w-100 table-striped\"\\> \n" +
"          <tr>\n" +
"            <th>ID</th>\n" +
"            <th>Nombre</th>\n" +
"            <th>Descripción</th>\n" +
"            <th>Precio</th>\n" +
"            <th>Inventario</th>\n" +
"            <th>categoria</th>\n" +
"            <th>Eliminar</th>\n" +
"            <th>Actualizar</th>\n" +
"          </tr>");
             out.println(" <tr>\n" +
"            <th><a class=\"btn btn-light\" href=\"VerProducto\" id=\"\">1</a></th>\n" +
"            <th>Iphone 13</th>\n" +
"            <th>Iphone 13 de 128gb color blanco.</th>\n" +
"            <th>$25,000</th>\n" +
"            <th>30</th>\n" +
"            <th>1</th>\n" +
"            <th><a class=\"btn btn-danger\" href=\"ProductoEliminado\" id=\"\">Eliminar</a></th>\n" +
"            <th><a class=\"btn btn-success\" href=\"EditProducto\" id=\"\">Actualizar</a></th>\n" +
"          </tr>\n" +
"          \n" +
"      </div>\n" +
"    </div>");
             out.println(" <tr>\n" +
"            <th><a class=\"btn btn-light\" href=\"VerProducto\" id=\"\">2</a></th>\n" +
"            <th>Iphone 14</th>\n" +
"            <th>Iphone 14 de 128gb color Morado.</th>\n" +
"            <th>$35,000</th>\n" +
"            <th>15</th>\n" +
"            <th>1</th>\n" +
"            <th><a class=\"btn btn-danger\" href=\"ProductoEliminado\" id=\"\">Eliminar</a></th>\n" +
"            <th><a class=\"btn btn-success\" href=\"EditProducto\" id=\"\">Actualizar</a></th>\n" +
"          </tr>\n" +
"          \n" +
"      </div>\n" +
"    </div>");
             
              out.println(" </body>\n" +
"</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
