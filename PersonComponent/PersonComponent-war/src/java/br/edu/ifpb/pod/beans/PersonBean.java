/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.beans;

import br.edu.ifpb.pod.busness.FacadeLocal;
import br.edu.ifpb.pod.entities.Person;
import java.io.ByteArrayInputStream;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Magdiel Bruno
 */
@ManagedBean(name = "personBean")
@RequestScoped
public class PersonBean {

    Person person= new Person();
    
    @EJB
    FacadeLocal facade;
    /**
     * Creates a new instance of PersonBean
     */
    public PersonBean() {
    }
    
    public String getName(){
        return person.getName();
    }
    
    public void setName(String name){
        person.setName(name);
    }
    
    public String getCpf(){
        return person.getCpf();
    }
    
    public void setCpf(String cpf){
        person.setCpf(cpf);
    }
    
    public String getEmail(){
        return person.getEmail();
    }
    
    public ByteArrayInputStream[] getPhoto1(){
        return person.getPhoto1();
    }
    
    public ByteArrayInputStream[] getPhoto2(){
        return person.getPhoto2();
    }
    
    public ByteArrayInputStream[] getPhoto3(){
        return person.getPhoto3();
    }
    
    public ByteArrayInputStream[] getPhoto4(){
        return person.getPhoto4();
    }
    
    public String register(){
        facade.registerPerson(this.person);
        return "home";
    }
}
