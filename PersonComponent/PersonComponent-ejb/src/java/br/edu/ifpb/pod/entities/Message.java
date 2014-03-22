/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Magdiel Bruno
 */
@Entity
public class Message implements Serializable{
    @Id
    @GeneratedValue(generator = "seq_message", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length=128)
    private String message;
}
