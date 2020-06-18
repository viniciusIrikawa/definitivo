/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import domain.FolhaRN;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class FolhaBeans {
    private double salarioBruto, inss,  irrf, salarioLiquido;
    private FolhaRN fprn;
    public FolhaBeans() {
    }
    
    public void calcularFolha(){
        fprn = new FolhaRN(this.salarioBruto);
        fprn.calcularInss();
        fprn.calcularIrrf();
        fprn.calcularSalarioLiquido();
        setInss(fprn.getInss());
        setIrrf(fprn.getIrrf());
        setSalarioLiquido(fprn.getSalarioLiquido());
    }
    
    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getIrrf() {
        return irrf;
    }

    public void setIrrf(double irrf) {
        this.irrf = irrf;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }
    
    
}
