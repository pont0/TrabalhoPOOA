/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.locadora.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/**
 *
 * @author pablo
 */

@Entity

@Table(catalog = "locadora", schema = "")
@NamedQueries({
    @NamedQuery(name = "Aluguel.findAll", query = "SELECT a FROM Aluguel a")
    , @NamedQuery(name = "Aluguel.findById", query = "SELECT a FROM Aluguel a WHERE a.id = :id")
    , @NamedQuery(name = "Aluguel.findByLocatario", query = "SELECT a FROM Aluguel a WHERE a.locatario = :locatario")
    , @NamedQuery(name = "Aluguel.findByModelo", query = "SELECT a FROM Aluguel a WHERE a.modelo = :modelo")
    , @NamedQuery(name = "Aluguel.findByDataEmprestimo", query = "SELECT a FROM Aluguel a WHERE a.dataEmprestimo = :dataEmprestimo")
    , @NamedQuery(name = "Aluguel.findByFoiDevolvido", query = "SELECT a FROM Aluguel a WHERE a.foiDevolvido = :foiDevolvido")
    })

public class Aluguel implements Serializable {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
             
    @Column (nullable = false)
    private int numeroDiasEmprestimo;
     
    @ManyToOne
    @JoinColumn(name = "idUsuario")
   private  Usuario locatario;
     
   
    @ManyToOne
    @JoinColumn(name = "idModelo")
    private  Modelo modelo;
   
   @Column(columnDefinition = "DATE")
    private LocalDate dataEmprestimo;
   
    @Column 
    private boolean foiDevolvido;

    public Aluguel() {
    }

    public Aluguel(int id, int numeroDiasEmprestimo, Usuario locatario, Modelo modelo, LocalDate dataEmprestimo, boolean foiDevolvido) {
        this.id = id;
        this.numeroDiasEmprestimo = numeroDiasEmprestimo;
        this.locatario = locatario;
        this.modelo = modelo;
        this.dataEmprestimo = dataEmprestimo;
        this.foiDevolvido = foiDevolvido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroDiasEmprestimo() {
        return numeroDiasEmprestimo;
    }

    public void setNumeroDiasEmprestimo(int numeroDiasEmprestimo) {
        this.numeroDiasEmprestimo = numeroDiasEmprestimo;
    }

    public Usuario getLocatario() {
        return locatario;
    }

    public void setLocatario(Usuario locatario) {
        this.locatario = locatario;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public boolean isFoiDevolvido() {
        return foiDevolvido;
    }

    public void setFoiDevolvido(boolean foiDevolvido) {
        this.foiDevolvido = foiDevolvido;
    }
    
    
    
    
}
