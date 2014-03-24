/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.business;

import br.edu.ifpb.pod.entities.User;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    @Override
    public User validatedToken(String token) {
        try{
            User u = new User();
            Calendar c = new GregorianCalendar();
            Date d = new Date();
            c.setTime(d);
            Query query = manager.createQuery("select u from User u where u.token:=token");
            query.setParameter("token", token);
            u = (User) query.getSingleResult();
            
            if((c.get(Calendar.HOUR_OF_DAY))-(u.getHourCreateToken().get(Calendar.HOUR_OF_DAY))<=1){
                return u;
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        } 
    }
    
}
