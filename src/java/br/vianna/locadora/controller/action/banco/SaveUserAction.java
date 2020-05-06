/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.controller.action.banco;

import br.vianna.locadora.controller.ICommanderAction;
import br.vianna.locadora.controller.action.viewer.CallCadastreseAction;
import br.vianna.locadora.controller.action.viewer.Login.CallLoginAction;
import br.vianna.locadora.model.DAO.impl.UsuarioDAO;
import br.vianna.locadora.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablo
 */
public class SaveUserAction implements ICommanderAction {

    public SaveUserAction() {
    }

    @Override
    public boolean ehRestrito() {
    return true;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    Usuario user = new Usuario(0, false, 
            request.getParameter("cpNome"), 
            request.getParameter("cpLogin"), 
            request.getParameter("cpSenha"));
    user.setEmail(request.getParameter("cpEmail"));
    
    if(user.getSenha().length() < 4){
        
          //String[] a = request.getParameterValues("abc");
        request.setAttribute("err", "senha muito curta");
        request.setAttribute("user", user); 
        new CallCadastreseAction().executar(request, response);
        
    }else{
    
    new UsuarioDAO().inserir(user);
    request.setAttribute("succ", "Usuário Salvo com sucesso!");
    new CallLoginAction().executar(request, response);
    }
    }
    
}
