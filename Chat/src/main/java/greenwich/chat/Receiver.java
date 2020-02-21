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

    public void setIp(String ip) {
        this.ipAddress = ip;
    }

    public String getIp() {
        return ipAddress;
    }

    public InetAddress getIpAddress() throws Exception {   
        return InetAddress.getByName(ipAddress);    
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
