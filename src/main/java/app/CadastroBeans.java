/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import infra.Cadastro;
import infra.Dados;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
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
public class CadastroBeans {
    private Dados dados = new Dados();
    private List<Dados> dado = new ArrayList<Dados>();
    public CadastroBeans() {
  
    }
    
    public Dados buscar(String nome){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("derbypersistence");
       EntityManager em = emf.createEntityManager();
       Dados d = null;
       try{
        d = em.find(Dados.class, nome);
       }finally{
           em.close();
       }
        return d; 
    }
 
    
    public void selecionar(Dados dados){
        this.dados = dados;
    }
    public void excluir(Dados dados){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("derbypersistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        dados = em.merge(dados);
        em.remove(dados);
        etx.commit();
        em.close();
        emf.close();
    }

    public Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    public String cadastrar(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("derbypersistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.merge(dados);
        etx.commit();
        em.close();
        emf.close();
        return "tabelaWEB";
    }

    public List<Dados> getDado() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("derbypersistence");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select p from Dados p", Dados.class);
        List<Dados> ds = q.getResultList();
        em.close();
        emf.close();
        return ds;
    }

    public void setDado(List<Dados> dado) {
        this.dado = dado;
    }
    

    
}
