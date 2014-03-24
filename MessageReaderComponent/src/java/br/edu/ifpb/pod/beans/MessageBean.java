/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.beans;

import br.edu.ifpb.pod.business.AutenticatorUserService;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.Naming;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Magdiel Bruno
 */
@ManagedBean
@RequestScoped
public class MessageBean {
    private String photo;
    private String[] mensagem;

    public String[] getMensagem() {
        return mensagem;
    }

    public void setMensagem(String[] mensagem) {
        this.mensagem = mensagem;
    }
    
    

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    
    public String auth(){
        File file = new File(this.getPhoto());
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            ByteArrayInputStream in = new ByteArrayInputStream(bFile);
            AutenticatorUserService auth = (AutenticatorUserService) Naming.lookup("rmi://localhost/AutenticatorService");
            String autenticator = auth.authUser(in);
            String message = auth.validatedToken(autenticator);
            String[] text = message.split(message);
            this.setMensagem(text);
            return "message";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }
    
}
