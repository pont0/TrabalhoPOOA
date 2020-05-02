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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */

@Entity
@Table(catalog = "locadora", schema = "")
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m")
    , @NamedQuery(name = "Modelo.findById", query = "SELECT m FROM Modelo m WHERE m.id = :id")
    , @NamedQuery(name = "Modelo.findByNome", query = "SELECT m FROM Modelo m WHERE m.nome = :nome")
    , @NamedQuery(name = "Modelo.findByCategoria", query = "SELECT m FROM Modelo m WHERE m.categoria = :categoria")
    , @NamedQuery(name = "Modelo.findByPrecoLocacao", query = "SELECT m FROM Modelo m WHERE m.precoLocacao = :precoLocacao")
    , @NamedQuery(name = "Modelo.findByAlugados", query = "SELECT m FROM Modelo m WHERE m.alugados = :alugados")})
public class Modelo extends Veiculo implements Serializable{
    
   @Column(nullable = false)
    private double precoLocacao;
   
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    
    @OneToMany(mappedBy = "modelo")
    private List <Aluguel> alugados;

    public Modelo(double precoLocacao, Categoria categoria, List<Aluguel> alugados) {
        this.precoLocacao = precoLocacao;
        this.categoria = categoria;
        this.alugados = alugados;
    }

    public Modelo(double precoLocacao, Categoria categoria, List<Aluguel> alugados, int id, String nome) {
        super(id, nome);
        this.precoLocacao = precoLocacao;
        this.categoria = categoria;
        this.alugados = alugados;
    }
    
    

    public Modelo() {
    }

 
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }



    public double getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(double precoLocacao) {
        this.precoLocacao = precoLocacao;
    }
    
    
    
    
}
