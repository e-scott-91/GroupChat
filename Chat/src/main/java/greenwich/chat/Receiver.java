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
public class Receiver {
    private static Receiver instance = null;
    private static User receiver;
    private String ipAddress;
    private int port;
    private int id;

    private Receiver() {

    }

    public static Receiver getInstance() {
        if (instance == null) {
            instance = new Receiver();
        }
        return instance;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public User getReceiver(){
        return this.receiver;
    }
    
    public String getIp() {
        return receiver.ip;
    }


    public int getPort() {
        return receiver.port;
    }


    public int getId() {
        return receiver.id;
    }
}
