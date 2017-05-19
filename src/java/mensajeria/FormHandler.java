/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eddy_
 */
public class FormHandler extends HttpServlet {

    //DBhandler dbh = new DBhandler();
    

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
        
        Mensaje msg;
        
        String origin = request.getParameter("origin");
        String url;
        String nombre = (String) request.getParameter("nombre");
        
        switch (origin) {
            case "envio":
                url = "/added.html";
                System.out.println("envio");
                nombre = request.getParameter("para");
                msg = new Mensaje(request.getParameter("de"), request.getParameter("para"), request.getParameter("contenido"));
                DBhandler.storeMessage(msg);
                break;
            case "lectura": 
                System.out.println("lectura");
                url = "/ver.jsp";
            break;
            case "login":
                System.out.println("login");
                if(DBhandler.verifyUser((String)request.getParameter("username"), (String)request.getParameter("password"))){
                    url = "/inicio.jsp";
                }
                else {
                     url = "/login.jsp";
                }
                break;
            default :
                url = "/login.jsp";
        }
        request.setAttribute("nombre", nombre);
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

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
