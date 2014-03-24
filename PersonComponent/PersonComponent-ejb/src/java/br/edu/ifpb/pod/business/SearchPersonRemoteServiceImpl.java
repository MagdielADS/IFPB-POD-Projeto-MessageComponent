/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.business;

import br.edu.ifpb.pod.entities.Person;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Magdiel Bruno
 */
public class SearchPersonRemoteServiceImpl extends UnicastRemoteObject implements SearchPersonRemoteService{
    @PersistenceContext(unitName = "Pod-PU")
    private EntityManager manager;
    
    public SearchPersonRemoteServiceImpl() throws RemoteException{
        super();
    }

    @Override
    public String searchPerson(String email) throws RemoteException {
        Query query = manager.createQuery("select p from Person p where p.email:=email");
        query.setParameter("email", email);
        Person p = (Person) query.getSingleResult();
        return p.getEmail()+"-"+p.getName();
    }        
}
