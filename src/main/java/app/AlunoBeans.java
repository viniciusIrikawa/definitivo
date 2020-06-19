/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

//import domain.MediaRN;
import infra.Aluno;
import infra.JPAUtils;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class AlunoBeans {
    private int id;
   
    private Aluno alunos = new Aluno();
    private List<Aluno> alunosList = new ArrayList<Aluno>();
    private double media, nota1, nota2, nota3, nota4, notafinal;
    private String cpf, nome, rg, datanasc, sexo, status;
    private String condicao;
   // private MediaRN mrn;
    
    public AlunoBeans() {
    }

    public void calcular2(){
        setNota1(alunos.getNota1());
        setNota2(alunos.getNota2());
        setNota3(alunos.getNota3());
        setNota4(alunos.getNota4());
        
        media = (nota1 + nota2 + nota3 + nota4)/4;
        setNotafinal(media);
        
        if(media >= 6){
           condicao = "Aprovado";
        } else if(media < 6 && media >= 4){
            condicao = "Prova Final";
        }else if(media < 4){
            condicao = "Reprovado";
        }
        
        setStatus(condicao);
    }
    
  // public void calcular(){
  //   mrn = new MediaRN(nota1, nota2, nota3, nota4);
  //    mrn.calcularNota();
  //    setMedia(mrn.getMedia());
  //
  // }

    public void excluir(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("derbypersistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        alunos = em.merge(alunos);
        em.remove(alunos);
        etx.commit();
        em.close();
        emf.close();
    }
    
    public String salvar(){
        EntityManager em = JPAUtils.getEntityManager();
       
        alunos.setCpf(getCpf());
        alunos.setNome(getNome());
        alunos.setRg(getRg());
        alunos.setDatanasc(getDatanasc());
        alunos.setSexo(getSexo());
        alunos.setNotafinal(getNotafinal());
        alunos.setStatus(getStatus());
        alunos.setNota1(getNota1());
        alunos.setNota2(getNota2());
        alunos.setNota3(getNota3());
        alunos.setNota4(getNota4());
        
        EntityTransaction ets = em.getTransaction();
        
        ets.begin();
        em.persist(alunos);
        ets.commit();
        em.close();
        return "tabela";
    }

    
    public Aluno getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> getAlunosList() {
        EntityManager em = JPAUtils.getEntityManager();
        Query q = em.createQuery("select a from Aluno a", Aluno.class);
        List<Aluno> ds = q.getResultList();
        em.close();
        em.close();
        return ds;
    }

    public void setAlunosList(List<Aluno> alunosList) {
        this.alunosList = alunosList;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(double notafinal) {
        this.notafinal = notafinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
