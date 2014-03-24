/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.business;

import br.edu.ifpb.pod.entities.Message;
import br.edu.ifpb.pod.entities.Person;
import br.edu.ifpb.pod.rmi.opencv.server.OpenCVRemoteService;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Local(FacadeLocal.class)
public class FacadeImpl implements FacadeLocal{
    @PersistenceContext(unitName = "Pod-PU")
    private EntityManager manager;
    
    
    
    @Override
    public void registerPerson(Person person) {
        manager.persist(person);
    }
    
    @Override
    public void registerMessage(Message message) {
        manager.persist(message);
    }

    @Override
    public void updatePerson(Person person) {
        manager.merge(person);
    }

    @Override
    public void removePerson(Person person) {
        Person p = manager.merge(person);
        manager.remove(p);
    }

    @Override
    public List<Person> listPerson() {
        Query query = manager.createQuery("select p from Person p");
        return query.getResultList();
    }

    @Override
    public String sendPhotos(ByteArrayInputStream... photos) {
        try {
            OpenCVRemoteService open = (OpenCVRemoteService) Naming.lookup("rmi://200.129.71/8686/OpenCVService");
            return open.registry(photos);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(FacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean authAdministrator(String login, String password) {
        if((login.equals("admin"))&(password.equals("123456"))){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public Person searchPersonById(Long id) {
        Query query = manager.createQuery("select p from Person p where p.id:=id");
        query.setParameter("id", id);
        return (Person) query.getSingleResult();
    }
}
