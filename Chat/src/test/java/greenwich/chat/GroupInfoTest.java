/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.io.PrintWriter;
import java.util.Set;
import javax.swing.DefaultListModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author emmascott
 */
public class GroupInfoTest {
    
    public GroupInfoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
        System.out.println("Before all");

    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        User user = new User(1,"1",1);
        User user2 = new User(2,"2",2);
        GroupInfo instance = GroupInfo.getInstance();
        instance.addInfo(user);
        instance.addInfo(user2);
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
        GroupInfo instance = GroupInfo.getInstance();
        User user = new User(1,"1",1);
        User user2 = new User(2,"2",2);
        instance.removeInfo(user);
        instance.removeInfo(user2);
        
    }


    /**
     * Test of addInfo method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testAddInfo() {
        System.out.println("addInfo");
        GroupInfo instance = GroupInfo.getInstance();
        User user = new User(3,"3",3);
        instance.addInfo(user);
        DefaultListModel<Integer> ids = instance.getIds();
        DefaultListModel<String> ips = instance.getIps();
        DefaultListModel<Integer> ports = instance.getPorts();
        int id = ids.get(2);
        String ip = ips.get(2);
        int port = ports.get(2);
        assertEquals(3,id);
        assertEquals("3",ip);
        assertEquals(3,port);
        instance.removeInfo(user);
    }

    /**
     * Test of removeInfo method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testRemoveInfo() {
        System.out.println("removeInfo");
        GroupInfo instance = GroupInfo.getInstance();
        User user2 = new User(2,"2",2);
        instance.removeInfo(user2);
        DefaultListModel<Integer> ids = instance.getIds();
        assertEquals(1,ids.size());
    }


    /**
     * Test of addSendToInfo method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testAddSendToInfo() {
        System.out.println("addSendToInfo");
        User user = new User(1,"1",1);
        GroupInfo instance = GroupInfo.getInstance();
        instance.addSendToInfo(user);
        DefaultListModel<Integer> ids = instance.getSendToIds();
        DefaultListModel<String> ips = instance.getSendToIps();
        DefaultListModel<Integer> ports = instance.getSendToPorts();
        int id = ids.get(0);
        String ip = ips.get(0);
        int port = ports.get(0);
        assertEquals(1,id);
        assertEquals("1",ip);
        assertEquals(1,port);
        instance.removeSendToInfo(user);
    }

    /**
     * Test of removeSendToInfo method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testRemoveSendToInfo() {
        System.out.println("removeSendToInfo");
        User user = new User(1,"1",1);
        User user2 = new User(2,"2",2);
        GroupInfo instance = GroupInfo.getInstance();
        instance.addSendToInfo(user);
        instance.addSendToInfo(user2);
        instance.removeSendToInfo(user);
        DefaultListModel<Integer> ids = instance.getSendToIds();
        assertEquals(1,ids.getSize());
    }
    
}
