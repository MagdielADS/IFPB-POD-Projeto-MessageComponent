/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.beans;

import br.edu.ifpb.pod.business.FacadeLocal;
import br.edu.ifpb.pod.entities.Message;
import br.edu.ifpb.pod.entities.Person;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;
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
    private Long id;
    Person person= new Person();
    Message message = new Message();

    public byte[] convPhoto(String caminho) {
        File file = new File(caminho);
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            return bFile;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String sendPhotos(byte[] p1, byte[] p2, byte[] p3, byte[] p4) {
        ByteArrayInputStream ph1 = new ByteArrayInputStream(p1);
        ByteArrayInputStream ph2 = new ByteArrayInputStream(p2);
        ByteArrayInputStream ph3 = new ByteArrayInputStream(p3);
        ByteArrayInputStream ph4 = new ByteArrayInputStream(p4);

        ByteArrayInputStream[] photos = new ByteArrayInputStream[4];
        photos[0] = ph1;
        photos[1] = ph2;
        photos[2] = ph3;
        photos[3] = ph4;

        String token = facade.sendPhotos(photos);
        return token;
    }

    public String register() {
        try {
            person.setPhoto1(convPhoto(photo1));
            person.setPhoto2(convPhoto(photo2));
            person.setPhoto3(convPhoto(photo3));
            person.setPhoto4(convPhoto(photo4));
            facade.registerPerson(person);
            person.setToken(sendPhotos(person.getPhoto1(), person.getPhoto2(), person.getPhoto3(), person.getPhoto4()));
            facade.updatePerson(person);
            return "home";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }

    public String transactionUpdate() {
        try {
            Person p = new Person();
            p = facade.searchPersonById(this.getId());
            person.setCpf(p.getCpf());
            person.setEmail(p.getEmail());
            person.setName(p.getName());
            person.setPhoto1(p.getPhoto1());
            person.setPhoto2(p.getPhoto2());
            person.setPhoto3(p.getPhoto3());
            person.setPhoto4(p.getPhoto4());
            return "update";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }

    public String update() {
        try {
            Person p = facade.searchPersonById(this.getId());
            p.setId(this.getId());
            p.setCpf(this.getCpf());
            p.setEmail(this.getCpf());
            p.setName(this.getName());
            p.setPhoto1(convPhoto(photo1));
            p.setPhoto2(convPhoto(photo2));
            p.setPhoto3(convPhoto(photo3));
            p.setPhoto4(convPhoto(photo4));

            facade.updatePerson(p);
            p.setToken(sendPhotos(p.getPhoto1(), p.getPhoto2(), p.getPhoto3(), p.getPhoto4()));
            facade.updatePerson(p);
            return "home";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }

    public String remove() {
        try {
            Person p = facade.searchPersonById(this.getId());
            facade.removePerson(p);
            return "home";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }
    
    public String sendMessage() {
        try {
            message.setPerson(facade.searchPersonById(this.getId()));
            facade.registerMessage(message);
            return "home";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
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
    
   
    
    public String getMessage(){
        return message.getMessage();
    }
    
    public void setMessage(String mes){
        message.setMessage(mes);
    }
    
    public List<Person> getListPerson(){
        return facade.listPerson();
    }
}
