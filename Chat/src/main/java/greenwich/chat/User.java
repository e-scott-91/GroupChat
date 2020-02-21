/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

/**
 *
 * @author emmascott
 */
public class User {
    int id;
    String ip;
    int port;
    
    public User(int id, String ip, int port){
        this.id = id;
        this.ip = ip;
        this.port = port;
    }
}
