/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.beans;

import br.edu.ifpb.pod.busness.FacadeLocal;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Magdiel Bruno
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
    @EJB
    FacadeLocal facade;
        
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String auth() {
        if(facade.authAdministrator(this.login, this.password)){
            return "home";
        }else{
            return "index";
        }
    }
    
}
