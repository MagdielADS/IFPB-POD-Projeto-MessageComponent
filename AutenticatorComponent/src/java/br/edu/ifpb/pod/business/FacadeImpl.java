/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.business;

import br.edu.ifpb.pod.entities.User;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Magdiel Bruno
 */
@Stateless
@Local(Facade.class)
public class FacadeImpl implements Facade{
    @PersistenceContext(unitName = "Pod-PU")
    private EntityManager manager;

    @Override
    public void persist(User u) {
        manager.persist(u);
    }

    @Override
    public void merge(User u) {
        manager.merge(u);
    }

    @Override
    public void remove(User u) {
        manager.remove(u);
    }

    @Override
    public User find(User u) {
        User user = new User();
        user = manager.find(User.class, u.getId());
        return user;
    }
    
}
