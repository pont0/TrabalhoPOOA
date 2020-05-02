/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.controller;

import br.vianna.locadora.controller.action.viewer.CallLoginAction;
import br.vianna.locadora.controller.action.viewer.CallHomeAction;
import br.vianna.locadora.controller.action.viewer.CallCadastreseAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablo
 */
@WebServlet(name = "CommanderController", urlPatterns = {"/app"})
public class CommanderController extends HttpServlet {

    private static HashMap <String, ICommanderAction> comandos;

    static{
    comandos = new HashMap<>();
    comandos.put(null, new CallLoginAction());
    comandos.put("login", new CallLoginAction());
    comandos.put("home", new CallHomeAction());
    comandos.put("cadastro", new CallCadastreseAction());
    
    
    }

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ac = request.getParameter("ac");
        
        try {
            comandos.get(ac).executar(request, response);
        } catch (Exception ex) {
            
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=erro");
            request.setAttribute("err","Comando não encontrado");
        
        rd.forward(request,response);
            
        }
        
        
        
        }
    }

    

//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>


