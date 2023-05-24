
package com.emergentes.controlador;

import com.emergentes.dao.GestionDAO;
import com.emergentes.dao.GestionDAOimpl;
import com.emergentes.modelo.Gestion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   GestionDAO dao = new GestionDAOimpl();
        
        Gestion ges = new Gestion();
        int id;
        
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("gestion", ges);
                request.getRequestDispatcher("frmgestion.jsp").forward(request, response);
                break;
            case "edit":
                // AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    // obtener el objeto que corresponde al registro
                    ges = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Eror al obtener registro " + ex.getMessage());
                }
                // Colocar como atributo
                request.setAttribute("gestion", ges);
                // Transferir el control a frmgestion.jsp
                request.getRequestDispatcher("frmgestion.jsp").forward(request, response);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("Inicio");
                break;
            case "view":
                List<Gestion> lista = new ArrayList<Gestion>(); 
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar "+ex.getMessage());
                }
                request.setAttribute("gestion", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                break;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion =  request.getParameter("descripcion");
        int cantidad =  Integer.parseInt(request.getParameter("cantidad"));
        float precio = Float.parseFloat(request.getParameter("precio"));
        String categoria =  request.getParameter("categoria");
        
        Gestion ges = new Gestion();
        
        ges.setId(id);
        ges.setDescripcion(descripcion);
        ges.setCantidad(cantidad);
        ges.setPrecio(precio);
        ges.setCategoria(categoria);
        
        
        GestionDAO dao = new GestionDAOimpl();
        
        if (id == 0){
            try {
                // Nuevo
                dao.insert(ges);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        }
        else{
            try {
                // Edición
                dao.update(ges);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("Inicio");
    }
        
        
    

}
