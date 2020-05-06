/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.model.DTO;

/**
 *
 * @author pablo
 */
public class UsuarioLoginDTO {
    
    private int id;
    private String nome;
    private boolean ehAdministrador;

    public UsuarioLoginDTO() {
    }

    public UsuarioLoginDTO(int id, String nome, boolean ehAdministrador) {
        this.id = id;
        this.nome = nome;
        this.ehAdministrador = ehAdministrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEhAdministrador() {
        return ehAdministrador;
    }

    public void setEhAdministrador(boolean ehAdministrador) {
        this.ehAdministrador = ehAdministrador;
    }
    
    
    
}
