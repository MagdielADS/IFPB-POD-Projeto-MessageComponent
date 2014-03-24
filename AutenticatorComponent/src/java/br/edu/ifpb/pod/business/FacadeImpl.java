/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.business;

import br.edu.ifpb.pod.entities.Person;
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
    public void persist(Person u) {
        manager.persist(u);
    }

    @Override
    public void merge(Person u) {
        manager.merge(u);
    }

    @Override
    public void remove(Person u) {
        manager.remove(u);
    }

    @Override
    public Person find(Person u) {
        Person user = new Person();
        user = manager.find(Person.class, u.getId());
        return user;
    }

    @Override
    public Person validatedToken(String token) {
        try{
            Person u = new Person();
            Calendar c = new GregorianCalendar();
            Date d = new Date();
            c.setTime(d);
            Query query = manager.createQuery("select u from User u where u.token:=token");
            query.setParameter("token", token);
            u = (Person) query.getSingleResult();
            
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
