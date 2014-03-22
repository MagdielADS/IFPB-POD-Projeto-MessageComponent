/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.entities;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Magdiel Bruno
 */
@Entity
public class Person implements Serializable{
    @Id
    @GeneratedValue(generator = "seq_personcomponent", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length=80)
    private String name;
    @Column(length=15)
    private String cpf;
    @Column(length=40, nullable = false, unique=true)
    private String email;
    private ByteArrayInputStream[] photo1;
    private ByteArrayInputStream[] photo2;
    private ByteArrayInputStream[] photo3;
    private ByteArrayInputStream[] photo4;
    private String token;
    @OneToMany
    private List<Message> messages;

    public void addMessage(Message message){
        messages.add(message);
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ByteArrayInputStream[] getPhoto1() {
        return photo1;
    }

    public void setPhoto1(ByteArrayInputStream[] photo1) {
        this.photo1 = photo1;
    }

    public ByteArrayInputStream[] getPhoto2() {
        return photo2;
    }

    public void setPhoto2(ByteArrayInputStream[] photo2) {
        this.photo2 = photo2;
    }

    public ByteArrayInputStream[] getPhoto3() {
        return photo3;
    }

    public void setPhoto3(ByteArrayInputStream[] photo3) {
        this.photo3 = photo3;
    }

    public ByteArrayInputStream[] getPhoto4() {
        return photo4;
    }

    public void setPhoto4(ByteArrayInputStream[] photo4) {
        this.photo4 = photo4;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
