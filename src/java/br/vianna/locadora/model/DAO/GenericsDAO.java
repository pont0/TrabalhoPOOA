/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.model.DAO;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pablo
 */
public abstract class GenericsDAO<C, K> {

    protected EntityManager conexao;
    private EntityManagerFactory emf;

    public GenericsDAO() {

        emf = Persistence.createEntityManagerFactory("LocadoraCarroBomPU");
        conexao = emf.createEntityManager();
    }

    public void close(){
       conexao.close();
       emf.close();
    }
    
    public EntityManager getConexao() {
        return conexao;
    }
    
    public abstract C inserir(C obj) throws SQLException;

    public abstract C alterar(C obj) throws SQLException;

    public abstract void apagar(K key) throws SQLException;

    public abstract C buscarUm(K key) throws SQLException;

    public abstract List<C> buscarTodos() throws SQLException;

}
