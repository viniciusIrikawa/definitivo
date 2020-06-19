/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "ALUNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findById", query = "SELECT a FROM Aluno a WHERE a.id = :id"),
    @NamedQuery(name = "Aluno.findByCpf", query = "SELECT a FROM Aluno a WHERE a.cpf = :cpf"),
    @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome"),
    @NamedQuery(name = "Aluno.findByRg", query = "SELECT a FROM Aluno a WHERE a.rg = :rg"),
    @NamedQuery(name = "Aluno.findByDatanasc", query = "SELECT a FROM Aluno a WHERE a.datanasc = :datanasc"),
    @NamedQuery(name = "Aluno.findBySexo", query = "SELECT a FROM Aluno a WHERE a.sexo = :sexo"),
    @NamedQuery(name = "Aluno.findByNotafinal", query = "SELECT a FROM Aluno a WHERE a.notafinal = :notafinal"),
    @NamedQuery(name = "Aluno.findByStatus", query = "SELECT a FROM Aluno a WHERE a.status = :status"),
    @NamedQuery(name = "Aluno.findByTitulo", query = "SELECT a FROM Aluno a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Aluno.findByCargahoraria", query = "SELECT a FROM Aluno a WHERE a.cargahoraria = :cargahoraria"),
    @NamedQuery(name = "Aluno.findByValor", query = "SELECT a FROM Aluno a WHERE a.valor = :valor"),
    @NamedQuery(name = "Aluno.findByNota1", query = "SELECT a FROM Aluno a WHERE a.nota1 = :nota1"),
    @NamedQuery(name = "Aluno.findByNota2", query = "SELECT a FROM Aluno a WHERE a.nota2 = :nota2"),
    @NamedQuery(name = "Aluno.findByNota3", query = "SELECT a FROM Aluno a WHERE a.nota3 = :nota3"),
    @NamedQuery(name = "Aluno.findByNota4", query = "SELECT a FROM Aluno a WHERE a.nota4 = :nota4")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "RG")
    private String rg;
    @Column(name = "DATANASC")
    private String datanasc;
    @Column(name = "SEXO")
    private String sexo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTAFINAL")
    private Double notafinal;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "CARGAHORARIA")
    private String cargahoraria;
    @Column(name = "VALOR")
    private String valor;
    @Column(name = "NOTA1")
    private Double nota1;
    @Column(name = "NOTA2")
    private Double nota2;
    @Column(name = "NOTA3")
    private Double nota3;
    @Column(name = "NOTA4")
    private Double nota4;

    public Aluno() {
    }

    public Aluno(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(Double notafinal) {
        this.notafinal = notafinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(String cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getNota3() {
        return nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    public Double getNota4() {
        return nota4;
    }

    public void setNota4(Double nota4) {
        this.nota4 = nota4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "infra.Aluno[ id=" + id + " ]";
    }
    
}
