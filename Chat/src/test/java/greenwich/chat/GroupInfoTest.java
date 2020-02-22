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
        GroupInfo info = GroupInfo.getInstance();
        info = null;
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    //@BeforeAll
    //public static void setUpClass() {
    //}
    
    //@AfterAll
    //public static void tearDownClass() {
    //}
    
    //@BeforeEach
    //public void setUp() {
    //}
    
    //@AfterEach
    //public void tearDown() {
    //}

    /**
     * Test of getInstance method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testGetInstance() {
        System.out.println("getInstance");
        GroupInfo expResult = null;
        GroupInfo result = GroupInfo.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetInstance method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testResetInstance() {
        System.out.println("resetInstance");
        GroupInfo.resetInstance();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addInfo method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testAddInfo() {
        System.out.println("addInfo");
        User user = new User(1,"",1);
        GroupInfo instance = GroupInfo.getInstance();
        instance.addInfo(user);
        DefaultListModel<Integer> ids = instance.getIds();
        DefaultListModel<String> ips = instance.getIps();
        DefaultListModel<Integer> ports = instance.getPorts();
        int id = ids.get(0);
        String ip = ips.get(0);
        int port = ports.get(0);
        assertEquals(1,id);
        assertEquals("",ip);
        assertEquals(1,port);
    }

    /**
     * Test of removeInfo method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testRemoveInfo() {
        System.out.println("removeInfo");
        User user = null;
        GroupInfo instance = null;
        instance.removeInfo(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIds method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testGetIds() {
        System.out.println("getIds");
        GroupInfo instance = null;
        DefaultListModel<Integer> expResult = null;
        DefaultListModel<Integer> result = instance.getIds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIps method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testGetIps() {
        System.out.println("getIps");
        GroupInfo instance = null;
        DefaultListModel<String> expResult = null;
        DefaultListModel<String> result = instance.getIps();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPorts method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testGetPorts() {
        System.out.println("getPorts");
        GroupInfo instance = null;
        DefaultListModel<Integer> expResult = null;
        DefaultListModel<Integer> result = instance.getPorts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addWriter method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testAddWriter() {
        System.out.println("addWriter");
        PrintWriter writer = null;
        GroupInfo instance = null;
        instance.addWriter(writer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addWriterBK method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testAddWriterBK() {
        System.out.println("addWriterBK");
        int key = 0;
        PrintWriter writer = null;
        GroupInfo instance = null;
        instance.addWriterBK(key, writer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeWriter method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testRemoveWriter() {
        System.out.println("removeWriter");
        PrintWriter writer = null;
        GroupInfo instance = null;
        instance.removeWriter(writer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeWriterBK method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testRemoveWriterBK() {
        System.out.println("removeWriterBK");
        int key = 0;
        GroupInfo instance = null;
        instance.removeWriterBK(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWriters method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testGetWriters() {
        System.out.println("getWriters");
        GroupInfo instance = null;
        Set<PrintWriter> expResult = null;
        Set<PrintWriter> result = instance.getWriters();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWriterBK method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testGetWriterBK() {
        System.out.println("getWriterBK");
        int key = 0;
        GroupInfo instance = null;
        PrintWriter expResult = null;
        PrintWriter result = instance.getWriterBK(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSendToIds method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testGetSendToIds() {
        System.out.println("getSendToIds");
        GroupInfo instance = null;
        DefaultListModel<Integer> expResult = null;
        DefaultListModel<Integer> result = instance.getSendToIds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSendToIps method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testGetSendToIps() {
        System.out.println("getSendToIps");
        GroupInfo instance = null;
        DefaultListModel<String> expResult = null;
        DefaultListModel<String> result = instance.getSendToIps();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSendToPorts method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testGetSendToPorts() {
        System.out.println("getSendToPorts");
        GroupInfo instance = null;
        DefaultListModel<Integer> expResult = null;
        DefaultListModel<Integer> result = instance.getSendToPorts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSendToInfo method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testAddSendToInfo() {
        System.out.println("addSendToInfo");
        User user = null;
        GroupInfo instance = null;
        instance.addSendToInfo(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSendToInfo method, of class GroupInfo.
     */
    @org.junit.jupiter.api.Test
    public void testRemoveSendToInfo() {
        System.out.println("removeSendToInfo");
        User user = null;
        GroupInfo instance = null;
        instance.removeSendToInfo(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
