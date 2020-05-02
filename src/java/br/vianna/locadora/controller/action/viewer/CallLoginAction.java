/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.controller.action.viewer;

import br.vianna.locadora.controller.ICommanderAction;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablo
 */
public class CallLoginAction implements ICommanderAction {

    public CallLoginAction() {
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        
        rd.forward(request,response);
    }

    @Override
    public boolean ehRestrito() {
        return true;
    }
    
}
