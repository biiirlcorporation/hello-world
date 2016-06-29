/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.wservice.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DIULLIAN
 */
@Entity
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByEnderecoId", query = "SELECT e FROM Endereco e WHERE e.enderecoId = :enderecoId"),
    @NamedQuery(name = "Endereco.findByEnderecoLogradouro", query = "SELECT e FROM Endereco e WHERE e.enderecoLogradouro = :enderecoLogradouro"),
    @NamedQuery(name = "Endereco.findByEnderecoNumero", query = "SELECT e FROM Endereco e WHERE e.enderecoNumero = :enderecoNumero"),
    @NamedQuery(name = "Endereco.findByEnderecoComplemento", query = "SELECT e FROM Endereco e WHERE e.enderecoComplemento = :enderecoComplemento"),
    @NamedQuery(name = "Endereco.findByEnderecoBairro", query = "SELECT e FROM Endereco e WHERE e.enderecoBairro = :enderecoBairro"),
    @NamedQuery(name = "Endereco.findByEnderecoCep", query = "SELECT e FROM Endereco e WHERE e.enderecoCep = :enderecoCep"),
    @NamedQuery(name = "Endereco.findByEnderecoCidade", query = "SELECT e FROM Endereco e WHERE e.enderecoCidade = :enderecoCidade"),
    @NamedQuery(name = "Endereco.findByEnderecoEstado", query = "SELECT e FROM Endereco e WHERE e.enderecoEstado = :enderecoEstado")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "endereco_id")
    private Integer enderecoId;
    @Size(max = 300)
    @Column(name = "endereco_logradouro")
    private String enderecoLogradouro;
    @Column(name = "endereco_numero")
    private Integer enderecoNumero;
    @Size(max = 300)
    @Column(name = "endereco_complemento")
    private String enderecoComplemento;
    @Size(max = 200)
    @Column(name = "endereco_bairro")
    private String enderecoBairro;
    @Size(max = 10)
    @Column(name = "endereco_cep")
    private String enderecoCep;
    @Size(max = 200)
    @Column(name = "endereco_cidade")
    private String enderecoCidade;
    @Size(max = 200)
    @Column(name = "endereco_estado")
    private String enderecoEstado;
    @OneToMany(mappedBy = "endereco")
    private Collection<Aluno> alunoCollection;

    public Endereco() {
    }

    public Endereco(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }

    public void setEnderecoLogradouro(String enderecoLogradouro) {
        this.enderecoLogradouro = enderecoLogradouro;
    }

    public Integer getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(Integer enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoEstado() {
        return enderecoEstado;
    }

    public void setEnderecoEstado(String enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }

    @XmlTransient
    public Collection<Aluno> getAlunoCollection() {
        return alunoCollection;
    }

    public void setAlunoCollection(Collection<Aluno> alunoCollection) {
        this.alunoCollection = alunoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enderecoId != null ? enderecoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.enderecoId == null && other.enderecoId != null) || (this.enderecoId != null && !this.enderecoId.equals(other.enderecoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.wservice.model.Endereco[ enderecoId=" + enderecoId + " ]";
    }
    
}
