/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
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
public class SetupSocketTest {

    public static User user;
    public static GroupInfo info;
    public static Receiver receiver;
    public static Scanner in;
    public static PrintWriter out;
    public static Display1 display = Display1.getInstance();

    public SetupSocketTest() {
    }

    @BeforeAll
    public static void init() {
        System.out.println("set up class");
        SetupSocketTest.user = new User(1, "localhost", 3000);
        SetupSocketTest.info = GroupInfo.getInstance();
        SetupSocketTest.receiver = Receiver.getInstance();
        User self = new User(2,"localhost",2);
        receiver.setReceiver(self);

    }

    @AfterAll
    public static void tearDownClass() {
        SetupSocketTest.info.removeInfo(user);
    }

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {

    }


    /**
     * Test of initialiseSocket method, of class SetupSocket.
     */
    @Test
    public void testInitialiseSocket() {
        System.out.println("initialiseSocket");
        Thread mockServer = new Thread() {
            public void run() {
                Socket myServerSocket = null;
                try {
                    ServerSocket myServer = new ServerSocket(3000);
                    System.out.println("testRegisterInfo- server socket created.");
                    myServerSocket = myServer.accept();
                    System.out.println("testRegisterInfo- server socket connected.");
                    assertTrue(myServerSocket.isConnected());
                    myServerSocket.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        mockServer.start();
        SetupSocket instance = new SetupSocket(user, receiver, info,display);
        PrintWriter out = instance.initialiseSocket(user.ip, user.port);

    }

    /**
     * Test of registerInfo method, of class SetupSocket.
     */
    @Test
    public void testRegisterInfo() {
        System.out.println("registerInfo");
        Thread mockServer = new Thread() {
            public void run() {
                Socket myServerSocket = null;
                try {
                    ServerSocket myServer = new ServerSocket(3000);
                    System.out.println("testRegisterInfo myThread run() - server socket created.");
                    myServerSocket = myServer.accept();
                    PrintWriter p = new PrintWriter(myServerSocket.getOutputStream(), true);
                    Scanner s = new Scanner(myServerSocket.getInputStream());
                    System.out.println("testRegisterInfo myThread run() - accepted connection");
                    while (true) {
                        p.println("SUBMIT-ID");
                        int id = Integer.parseInt(s.nextLine());
                        assertEquals(2, id);
                        p.println("SUBMIT-IP");
                        String ip = s.nextLine();
                        assertEquals(ip, "localhost");
                        p.println("SUBMIT-PORT");
                        int port = Integer.parseInt(s.nextLine());
                        assertEquals(2, port);
                        synchronized (info) {
                            if (!info.getIds().contains(id)) {
                                User friend = new User(id, ip, port);
                                info.addInfo(friend);
                                break;
                            }
                        }
                    }
                    //Checking the registered information
                    DefaultListModel<Integer> ids = info.getIds();
                    int id = ids.get(0);
                    assertEquals(2, id);
                    myServerSocket.close();
                    myServer.close();
                    System.out.println("connections closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        mockServer.start();

        try {
            Socket socket = new Socket(user.ip, user.port);
            System.out.println("testRegisterInfo- connection successful");
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            SetupSocket instance = new SetupSocket(user, receiver, info,display);
            instance.registerInfo(in, out, receiver);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
