/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.model.DAO.impl;

import br.vianna.locadora.model.DAO.GenericsDAO;
import br.vianna.locadora.model.DTO.UsuarioLoginDTO;
import br.vianna.locadora.model.domain.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author pablo
 */
public class UsuarioDAO extends GenericsDAO<Usuario, Long> {

    @Override
    public Usuario inserir(Usuario obj) throws SQLException {

        conexao.getTransaction().begin();
        conexao.persist(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public Usuario alterar(Usuario obj) throws SQLException {

        conexao.getTransaction().begin();
        conexao.merge(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public void apagar(Long key) throws SQLException {

        Usuario u = buscarUm(key);

        conexao.getTransaction().begin();
        conexao.remove(u);
        conexao.getTransaction().commit();
    }

    @Override
    public Usuario buscarUm(Long key) throws SQLException {

          
        Query q = conexao.createQuery("SELECT u FROM Usuario WHERE u.id = :id");

        try {
            q.setParameter("id", key);
            return (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }

    }

    @Override
    public List<Usuario> buscarTodos() throws SQLException {

        Query q = conexao.createNamedQuery("Usuario.findAll");

        return q.getResultList();

    }
    
    public UsuarioLoginDTO buscarPeloLoginaESenha(String login, String senha) throws SQLException {
        
        Query q = conexao.createNamedQuery("Usuario.findByLoginaAndSenha");

        try {
            q.setParameter("log", login);
            q.setParameter("senha", senha);
            Usuario user = (Usuario) q.getSingleResult();
            UsuarioLoginDTO udto = new UsuarioLoginDTO(user.getId(), user.getNome(), user.getEhAdm());
            
            return udto;
            
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }
        
    }

}
