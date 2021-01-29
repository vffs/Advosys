/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.ifpe.edu.model.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Historico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Temporal(TemporalType.DATE)
    private Date dataHist;
    private int statusAnterior;
    private String descricao;
    private String parecer;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataHist() {
        return dataHist;
    }

    public void setDataHist(Date dataHist) {
        this.dataHist = dataHist;
    }

    public int getStatusAnterior() {
        return statusAnterior;
    }

    public void setStatusAnterior(int statusAnterior) {
        this.statusAnterior = statusAnterior;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }
    
    
    
}
