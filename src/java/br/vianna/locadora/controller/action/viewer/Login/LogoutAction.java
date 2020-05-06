/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.controller.action.viewer.Login;

import br.vianna.locadora.controller.ICommanderAction;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablo
 */
public class LogoutAction implements ICommanderAction {

    
    @Override
    public boolean ehRestrito() {
    return false;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
//        apaga os dados da sessão
    request.getSession().invalidate();
    
    new CallLoginAction().executar(request, response);
        
    }
    
}
