/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.business;

import br.edu.ifpb.pod.entities.User;

/**
 *
 * @author Magdiel Bruno
 */
public interface Facade {
    public void persist(User u);
    public void merge(User u);
    public void remove(User u);
    public User find(User u);
    public User validatedToken(String token);
}
