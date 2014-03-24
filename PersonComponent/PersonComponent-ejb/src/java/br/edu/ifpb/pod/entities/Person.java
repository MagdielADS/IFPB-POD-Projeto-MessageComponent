/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

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
    @Lob @Basic(fetch= FetchType.EAGER) 
    private byte[] photo1;
    @Lob @Basic(fetch= FetchType.EAGER) 
    private byte[] photo2;
    @Lob @Basic(fetch= FetchType.EAGER) 
    private byte[] photo3;
    @Lob @Basic(fetch= FetchType.EAGER) 
    private byte[] photo4;
    private String token;
    
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

    public byte[] getPhoto1() {
        return photo1;
    }

    public void setPhoto1(byte[] photo1) {
        this.photo1 = photo1;
    }

    public byte[] getPhoto2() {
        return photo2;
    }

    public void setPhoto2(byte[] photo2) {
        this.photo2 = photo2;
    }

    public byte[] getPhoto3() {
        return photo3;
    }

    public void setPhoto3(byte[] photo3) {
        this.photo3 = photo3;
    }

    public byte[] getPhoto4() {
        return photo4;
    }

    public void setPhoto4(byte[] photo4) {
        this.photo4 = photo4;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
