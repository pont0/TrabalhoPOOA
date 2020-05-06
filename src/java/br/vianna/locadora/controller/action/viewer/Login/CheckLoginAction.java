/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.controller.action.viewer.Login;

import br.vianna.locadora.model.DTO.UsuarioLoginDTO;
import br.vianna.locadora.controller.ICommanderAction;
import br.vianna.locadora.controller.action.viewer.CallHomeAction;
import br.vianna.locadora.model.DAO.impl.UsuarioDAO;
import br.vianna.locadora.model.domain.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablo
 */
public class CheckLoginAction implements ICommanderAction {

    public CheckLoginAction() {
    }

    @Override
    public boolean ehRestrito() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //DTO
        
        String login = request.getParameter("cpLogin");
        String senha = request.getParameter("cpSenha");
        
        UsuarioLoginDTO user = new UsuarioDAO().buscarPeloLoginaESenha(login, senha);
        
        //guardar usuario logado na sessao
        
        if(user != null){
           request.getSession().setAttribute("user", user); 
           
           new CallHomeAction().executar(request, response);
        }else{
            //errar senha ou login
            request.setAttribute("err", "Login ou Senha incorreta");
            new CallLoginAction().executar(request, response);
        }
            
        
        
        
        
    }
    
}
