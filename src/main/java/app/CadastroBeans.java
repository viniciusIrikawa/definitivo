/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import infra.Cadastro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class CadastroBeans {
    Cadastro cadastro = new Cadastro();
    
    /**
     * Creates a new instance of CadastroBeans
     */
    public CadastroBeans() {
    }

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
    public String cadastrar(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("derbypersistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(cadastro);
        etx.commit();
        em.close();
        emf.close();
        return "cadastro";
    }
}
