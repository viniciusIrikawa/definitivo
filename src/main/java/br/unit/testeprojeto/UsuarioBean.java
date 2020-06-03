
package br.unit.testeprojeto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SessionScoped
@ManagedBean
public class UsuarioBean {
    private String user;
    private String email;
    private String password;
    private String phone;
    private String salvar;
    
    
     public String getSalvar() {
        return salvar;
    }
    public void salvarDados(){
        salvar = "Dados salvos";
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    

    
}
