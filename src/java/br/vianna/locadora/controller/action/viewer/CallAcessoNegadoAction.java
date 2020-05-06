/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.controller.action.viewer;

import br.vianna.locadora.controller.ICommanderAction;
import br.vianna.locadora.controller.action.viewer.Login.CallLoginAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablo
 */
public class CallAcessoNegadoAction implements ICommanderAction {

    public CallAcessoNegadoAction() {
    }

    @Override
    public boolean ehRestrito() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    request.setAttribute("err", "Acesso não autorizado");
    
    new CallLoginAction().executar(request, response);
    }
    
}
