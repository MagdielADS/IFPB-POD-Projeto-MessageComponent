/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.beans;

import br.edu.ifpb.pod.busness.FacadeLocal;
import br.edu.ifpb.pod.entities.Person;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Magdiel Bruno
 */
@ManagedBean(name = "personBean")
@RequestScoped
public class PersonBean implements Serializable{
    @EJB
    FacadeLocal facade;
    private String photo1, photo2, photo3, photo4;
    
    Person person= new Person();

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getPhoto4() {
        return photo4;
    }

    public void setPhoto4(String photo4) {
        this.photo4 = photo4;
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
    
    public void setEmail(String email){
        person.setEmail(email);
    }
    
//    public byte[] getPhoto1(){
//        return person.getPhoto1();
//    }
//    
//    public byte[] getPhoto2(){
//        return person.getPhoto2();
//    }
//    
//    public byte[] getPhoto3(){
//        return person.getPhoto3();
//    }
//    
//    public byte[] getPhoto4(){
//        return person.getPhoto4();
//    }
//    
//    public void setPhoto1(String caminho){
//        File photo = new File(caminho);
//        byte[] image = new byte[(int)photo.length()];
//        person.setPhoto1(image);
//    }
//    
//    public void setPhoto2(String caminho){
//        File photo = new File(caminho);
//        byte[] image = new byte[(int)photo.length()];
//        person.setPhoto2(image);
//    }
//    
//    public void setPhoto3(String caminho){
//        File photo = new File(caminho);
//        byte[] image = new byte[(int)photo.length()];
//        person.setPhoto3(image);
//    }
//    
//    public void setPhoto4(String caminho){
//        File photo = new File(caminho);
//        byte[] image = new byte[(int)photo.length()];
//        person.setPhoto4(image);
//    }
    
    public byte[] convPhoto(String caminho) {
        File file = new File(caminho);
        byte[] bFile = new byte[(int) file.length()];
 
        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
             return bFile;
        } catch (Exception e) {
	     e.printStackTrace();
        }
        return null;
    }
    
    public String register(){
        try{
            person.setPhoto1(convPhoto(photo1));
            person.setPhoto2(convPhoto(photo2));
            person.setPhoto3(convPhoto(photo3));
            person.setPhoto4(convPhoto(photo4));
            facade.registerPerson(person);
            System.out.println(photo1 + " " + photo2 + " " + photo3 + " " + photo4);
            return "register";
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
