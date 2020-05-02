/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.model.DAO.impl;


import br.vianna.locadora.model.DAO.GenericsDAO;
import br.vianna.locadora.model.domain.Categoria;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author pablo
 */
public class CategoriaDAO extends GenericsDAO<Categoria, Long>{
    
     @Override
    public Categoria inserir(Categoria obj) throws SQLException {

        conexao.getTransaction().begin();
        conexao.persist(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public Categoria alterar(Categoria obj) throws SQLException {

        conexao.getTransaction().begin();
        conexao.merge(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public void apagar(Long key) throws SQLException {

        Categoria c = buscarUm(key);

        conexao.getTransaction().begin();
        conexao.remove(c);
        conexao.getTransaction().commit();
    }

    @Override
    public Categoria buscarUm(Long key) throws SQLException {
      
        Query q = conexao.createQuery("SELECT c FROM Categoria WHERE c.id = :id");

        try {
            q.setParameter("id", key);
            return (Categoria) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }

    }

    @Override
    public List<Categoria> buscarTodos() throws SQLException {

        Query q = conexao.createNamedQuery("Categoria.findAll");

        return q.getResultList();

    }
}
