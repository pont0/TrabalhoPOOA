/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.model.DAO.impl;

import br.vianna.locadora.model.DAO.GenericsDAO;
import br.vianna.locadora.model.domain.Modelo;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author pablo
 */
public class ModeloDAO extends GenericsDAO<Modelo, Long> {

    @Override
    public Modelo inserir(Modelo obj) throws SQLException {

        conexao.getTransaction().begin();
        conexao.persist(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public Modelo alterar(Modelo obj) throws SQLException {

        conexao.getTransaction().begin();
        conexao.merge(obj);
        conexao.getTransaction().commit();
        return obj;
    }

    @Override
    public void apagar(Long key) throws SQLException {

        Modelo m = buscarUm(key);

        conexao.getTransaction().begin();
        conexao.remove(m);
        conexao.getTransaction().commit();
    }

    @Override
    public Modelo buscarUm(Long key) throws SQLException {
    
        Query q = conexao.createQuery("SELECT m FROM Modelo m WHERE m.id = :id");

        try {
            q.setParameter("id", key);
            return (Modelo) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException ex) {
            return null;
        }

    }

    @Override
    public List<Modelo> buscarTodos() throws SQLException {

        Query q = conexao.createNamedQuery("Modelo.findAll");

        return q.getResultList();

    }
    

}
