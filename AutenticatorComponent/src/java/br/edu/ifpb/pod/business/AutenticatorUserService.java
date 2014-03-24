/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.business;

import java.io.ByteArrayInputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Magdiel Bruno
 */
public interface AutenticatorUserService extends Remote{
    public String authUser(ByteArrayInputStream photo) throws RemoteException;
    public String validatedToken(String token) throws RemoteException;
}
