/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.business;

import br.edu.ifpb.pod.entities.Message;
import br.edu.ifpb.pod.entities.Person;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 *
 * @author Magdiel Bruno
 */
public interface FacadeLocal {
    public void registerPerson(Person person);
    public void updatePerson(Person person);
    public void removePerson(Person person);
    public List<Person> listPerson();
    public String sendPhotos(ByteArrayInputStream... person);
    public boolean authAdministrator(String login, String password);
    public void registerMessage(Message message);
    public Person searchPersonById(Long id);
}
