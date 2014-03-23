/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.busness;

import br.edu.ifpb.pod.entities.Message;
import br.edu.ifpb.pod.entities.Person;
import br.edu.ifpb.pod.rmi.opencv.server.OpenCVRemoteService;
import br.edu.ifpb.pod.rmi.opencv.server.OpenCVRemoteServiceException;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sun.awt.image.ByteArrayImageSource;

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
    public String sendPhotos(ByteArrayInputStream... photos) {
        try {
            OpenCVRemoteService open = (OpenCVRemoteService) Naming.lookup("rmi://200.129.71/OpenCVService");
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
    public void registerMessage(Message message) {
        manager.persist(message);
    }    
}
