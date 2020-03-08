/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;

/**
 *
 * @author emmascott
 */
public class UserManager {

    private static UserManager instance;
    private static DefaultListModel<User> users = new DefaultListModel<User>();
    private static DefaultListModel<Integer> ids = new DefaultListModel<Integer>();
    private static DefaultListModel<String> ips = new DefaultListModel<String>();
    private static DefaultListModel<Integer> ports = new DefaultListModel<Integer>();
    private static DefaultListModel<Integer> sendToids = new DefaultListModel<Integer>();
    private static DefaultListModel<String> sendToips = new DefaultListModel<String>();
    private static DefaultListModel<Integer> sendToports = new DefaultListModel<Integer>();
    private static Set<PrintWriter> writers = new HashSet<>();
    private static HashMap<Integer, PrintWriter> writersByKey = new HashMap<Integer, PrintWriter>();

    private UserManager() {

    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addInfo(User user) {
        ids.addElement(user.id);
        ips.addElement(user.ip);
        ports.addElement(user.port);
        users.addElement(user);
    }

    public void removeInfo(User user) {
        ids.removeElement(user.id);
        ips.removeElement(user.ip);
        ports.removeElement(user.port);
        users.removeElement(user);
    }

    public DefaultListModel<Integer> getIds() {
        return ids;
    }

    public DefaultListModel<String> getIps() {
        return ips;
    }

    public DefaultListModel<Integer> getPorts() {
        return ports;
    }
    
    public DefaultListModel<User> getUsers() {
        return users;
    }


    public void addWriter(int key, PrintWriter writer) {
        writers.add(writer);
        writersByKey.put(key, writer);
    }

    public void removeWriter(PrintWriter writer) {
        writers.remove(writer);
    }

    public void removeWriterBK(int key) {
        PrintWriter writer = getWriterBK(key);
        writer.println("this is working");
        this.removeWriter(writer);
        writersByKey.remove(key);
    }

    public Set<PrintWriter> getWriters() {
        return writers;
    }

    public PrintWriter getWriterBK(int key) {
        return writersByKey.get(key);
    }

    public DefaultListModel<Integer> getSendToIds() {
        return sendToids;
    }

    public DefaultListModel<String> getSendToIps() {
        return sendToips;
    }

    public DefaultListModel<Integer> getSendToPorts() {
        return sendToports;
    }

    public void addSendToInfo(User user) {
        sendToids.addElement(user.id);
        sendToips.addElement(user.ip);
        sendToports.addElement(user.port);
    }

    public void removeSendToInfo(User user) {
        sendToids.removeElement(user.id);
        sendToips.removeElement(user.ip);
        sendToports.removeElement(user.port);
    }

    public User getUserById(int id) {
        UserManager info = UserManager.getInstance();
        Object[] objUsers = info.getUsers().toArray();
        User[] users = new User[objUsers.length];
        for (int i = 0; i < objUsers.length; i++) {
            users[i] = (User) objUsers[i];
        }
        User user = null;
        for (int i = 0; i < objUsers.length; i++) {
            if (users[i].id == id) {
                user = users[i];
                break;
            }
        }
        return user;

    }
}
