/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.wservice.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DIULLIAN
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByAlunoId", query = "SELECT a FROM Aluno a WHERE a.alunoId = :alunoId"),
    @NamedQuery(name = "Aluno.findByAlunoCpf", query = "SELECT a FROM Aluno a WHERE a.alunoCpf = :alunoCpf"),
    @NamedQuery(name = "Aluno.findByAlunoNome", query = "SELECT a FROM Aluno a WHERE a.alunoNome = :alunoNome"),
    @NamedQuery(name = "Aluno.findByAlunodataNasc", query = "SELECT a FROM Aluno a WHERE a.alunodataNasc = :alunodataNasc")})
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aluno_id")
    private Integer alunoId;
    @Size(max = 20)
    @Column(name = "aluno_cpf")
    private String alunoCpf;
    @Size(max = 255)
    @Column(name = "aluno_nome")
    private String alunoNome;
    @Column(name = "aluno_dataNasc")
    @Temporal(TemporalType.DATE)
    private Date alunodataNasc;
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Aluno() {
    }

    public Aluno(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public String getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(String alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public Date getAlunodataNasc() {
        return alunodataNasc;
    }

    public void setAlunodataNasc(Date alunodataNasc) {
        this.alunodataNasc = alunodataNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoId != null ? alunoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.alunoId == null && other.alunoId != null) || (this.alunoId != null && !this.alunoId.equals(other.alunoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.wservice.model.Aluno[ alunoId=" + alunoId + " ]";
    }
    
}
