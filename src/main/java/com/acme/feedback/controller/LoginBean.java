package com.acme.feedback.controller;

import com.acme.feedback.facade.UsuarioFacade;
import com.acme.feedback.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean implements Serializable {
    
    @Inject
    private UsuarioFacade facade;
    
    private String login;
    
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String entrar(){
       
        Usuario usuario = facade.findByCredenciais(login, senha);
        if (usuario == null) {
            FacesMessage msg = new FacesMessage("Falha Autenticação", 
                    "Usuário e/ou senha inválidos.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
        
        return "principal";
    }
    
}
