/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.model.DAO.impl;

import br.vianna.locadora.model.DAO.GenericsDAO;
import br.vianna.locadora.model.domain.Aluguel;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author pablo
 */
public class AluguelDAO extends GenericsDAO<Aluguel, Long>{
    
     @Override
    public Aluguel inserir(Aluguel obj) throws SQLException {

        conexao.getTransaction().begin();
        conexao.persist(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public Aluguel alterar(Aluguel obj) throws SQLException {

        conexao.getTransaction().begin();
        conexao.merge(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public void apagar(Long key) throws SQLException {

        Aluguel a = buscarUm(key);

        conexao.getTransaction().begin();
        conexao.remove(a);
        conexao.getTransaction().commit();
    }

    @Override
    public Aluguel buscarUm(Long key) throws SQLException {
      
        Query q = conexao.createQuery("SELECT a FROM Aluguel a WHERE a.id = :id");

        try {
            q.setParameter("id", key);
            return (Aluguel) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }

    }

    @Override
    public List<Aluguel> buscarTodos() throws SQLException {

        Query q = conexao.createNamedQuery("Aluguel.findAll");

        return q.getResultList();

    }
}
