/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.business;

import br.edu.ifpb.pod.entities.User;
import br.edu.ifpb.pod.opencv.server.OpenCVRemoteService;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 *
 * @author Magdiel Bruno
 */
public class AutenticatorUserServiceImpl extends UnicastRemoteObject implements AutenticatorUserService{
    @EJB
    Facade facade;
    
    public AutenticatorUserServiceImpl() throws RemoteException{
        super();
    }
            
    @Override
    public String authUser(ByteArrayInputStream photo) throws RemoteException {
        try {
            User user = new User();
            OpenCVRemoteService open = (OpenCVRemoteService) Naming.lookup("rmi://200.129.71/OpenCVService");
            String token = open.recognize(photo);
            user.setToken(token);
            facade.persist(user);
            return token;
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(AutenticatorUserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String validatedToken(String token) throws RemoteException {
        User u = new User();
        u = facade.validatedToken(token);
        if(u!=null){
            this.notifySendMessage(u);
            String control = "TRUE-"+u.getName()+"-"+u.getEmail()+"-"+u.getMessage();
            return control;
        }else{
            return "FALSE";
        }
    }
    
    public void notifySendMessage(User u){
        User us = new User();
        us = facade.find(u);
        us.setvToken(false);
        facade.merge(us);
    }
}
