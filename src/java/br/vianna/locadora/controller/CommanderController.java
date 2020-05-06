/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.controller;

import br.vianna.locadora.controller.action.viewer.CallLivrosAction;
import br.vianna.locadora.controller.action.viewer.CallLivrosAction;
import br.vianna.locadora.controller.action.viewer.CallAcessoNegadoAction;
import br.vianna.locadora.controller.action.viewer.Login.LogoutAction;
import br.vianna.locadora.controller.action.viewer.Login.CheckLoginAction;
import br.vianna.locadora.controller.action.banco.SaveUserAction;
import br.vianna.locadora.controller.action.viewer.Login.CallLoginAction;
import br.vianna.locadora.controller.action.viewer.CallHomeAction;
import br.vianna.locadora.controller.action.viewer.CallCadastreseAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
    comandos.put("saveUser", new SaveUserAction());
    comandos.put("checkLogin", new CheckLoginAction());
    comandos.put("logout", new LogoutAction());
    comandos.put("acessoNegado", new CallAcessoNegadoAction());
    comandos.put("livros", new CallLivrosAction());
    
    
    }

    
    //@Override

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ac = request.getParameter("ac");
        
        try {
            
            //verificação de acesso
            if(comandos.get(ac).ehRestrito()){
                comandos.get(ac).executar(request, response); //se a action é liberada
            }else if(request.getSession().getAttribute("user")!=null){
                comandos.get(ac).executar(request, response); //se tem alguem na sessao
            }else{
                //nao tem ninguem na sessao e a action nao é liberada
                comandos.get("acessoNegado").executar(request, response);
            }
            
            
            
        }  catch (NullPointerException ex) {
            System.out.println(ex.getCause());
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=erro");
            request.setAttribute("err", "Comando não Encontrado!!!");
            rd.forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getCause());
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=erro");
            request.setAttribute("err", "Erro Geral do Sistema " + ex.getMessage());
            rd.forward(request, response);
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
