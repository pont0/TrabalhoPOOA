/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.model.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author pablo
 */

@Entity
@Table(catalog = "locadora", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"descricao"})})
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findById", query = "SELECT c FROM Categoria c WHERE c.id = :id")
    , @NamedQuery(name = "Categoria.findByDescri", query = "SELECT c FROM Categoria c WHERE c.descricao = :descricao")})
public class Categoria implements Serializable {
    @Column(nullable = false)
    
    private String descricao;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    
    
    @OneToMany(mappedBy = "categoria")
    private List<Modelo> modelos;

    public Categoria(String descricao, String detalhe, int id) {
        this.descricao = descricao;
        this.id = id;
    }

    public Categoria() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
