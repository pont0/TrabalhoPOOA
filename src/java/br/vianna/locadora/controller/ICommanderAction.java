/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablo
 */
public interface ICommanderAction {
    
    
    public boolean ehRestrito();
    
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
