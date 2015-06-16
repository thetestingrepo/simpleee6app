/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gyula
 */
@ManagedBean(name = "MessageView")
@RequestScoped
public class MessageView {
    @EJB
    private MessageFacade messageFacade;
    
    private Message message;

    public Message getMessage() {
       return message;
    }

    public int getNumberOfMessages(){
       return messageFacade.findAll().size();
    }

    public String postMessage(){
       this.messageFacade.create(message);
       return "theend";
    }
    public MessageView() {
        this.message = new Message();
    }
 
    
    
}
