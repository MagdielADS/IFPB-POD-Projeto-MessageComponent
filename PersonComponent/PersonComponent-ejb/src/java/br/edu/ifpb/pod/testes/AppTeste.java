/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.testes;

import br.edu.ifpb.pod.entities.Person;

/**
 *
 * @author Magdiel Bruno
 */
public class AppTeste {
    public static void main(String[] args) {
        Person person = new Person();
        //person.Photo1("c:\\Bibliotecas\\Imagens\\OpeningWindow.jpg");
        System.out.println(person.getPhoto1());
    }
}
