/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.busness;

import br.edu.ifpb.pod.entities.Person;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Magdiel Bruno
 */
public interface SearchPersonRemoteService extends Remote{
     public Person searchPerson(String email) throws RemoteException;
}
