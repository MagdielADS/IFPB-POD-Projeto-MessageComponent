/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.business;

import br.edu.ifpb.pod.entities.Person;

/**
 *
 * @author Magdiel Bruno
 */
public interface Facade {
    public void persist(Person u);
    public void merge(Person u);
    public void remove(Person u);
    public Person find(Person u);
    public Person validatedToken(String token);
}
