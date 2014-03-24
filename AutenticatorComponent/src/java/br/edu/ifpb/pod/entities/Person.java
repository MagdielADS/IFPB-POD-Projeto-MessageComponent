/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Magdiel Bruno
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length=80)
    private String name;
    @Column(length=80, unique=true)
    private String email;
    @Column(length=128)
    private String message;
    private String token;
    @Temporal(TemporalType.TIME)
    private Calendar hourCreateToken;
    private boolean vToken;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Calendar getHourCreateToken() {
        return hourCreateToken;
    }

    public void setHourCreateToken(Calendar hourCreateToken) {
        this.hourCreateToken = hourCreateToken;
    }

    public boolean isvToken() {
        return vToken;
    }

    public void setvToken(boolean vToken) {
        this.vToken = vToken;
    }
}
