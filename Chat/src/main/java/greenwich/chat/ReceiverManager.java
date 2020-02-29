/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.net.InetAddress;

/**
 *
 * @author emmascott
 */
public class ReceiverManager {
    private static ReceiverManager instance = null;
    private User receiver;


    private ReceiverManager() {

    }

    public static ReceiverManager getInstance() {
        if (instance == null) {
            instance = new ReceiverManager();
        }
        return instance;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public User getReceiver(){
        return this.receiver;
    }
    
    public String getRecIp() {
        return receiver.ip;
    }


    public int getRecPort() {
        return receiver.port;
    }


    public int getRecId() {
        return receiver.id;
    }
}
