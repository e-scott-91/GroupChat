/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
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
public class HandlerTest {
    Scanner in;
    PrintWriter out;
    GroupInfo info = GroupInfo.getInstance();
    Display1 display = Display1.getInstance();
    
    public HandlerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
        
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testRegisterInfoWithoutDuplicate(){
        System.out.println("registerInfo");
        Thread mockServer = new Thread() {
            public void run() {
                Socket myServerSocket = null;
                try {
                    ServerSocket myServer = new ServerSocket(3000);
                    System.out.println("testRegisterInfo- server socket created.");
                    myServerSocket = myServer.accept();
                    Handler handler = new Handler(myServerSocket,info,display);
                    System.out.println("testRegisterInfo- server socket connected.");
                    out = new PrintWriter(myServerSocket.getOutputStream(), true);
                    in = new Scanner(myServerSocket.getInputStream());
                    handler.registerInfo(out, in);
                    myServer.close();
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        
        mockServer.start();
        try {
            Socket socket = new Socket("localhost",3000);
            Scanner s = new Scanner(socket.getInputStream());
            PrintWriter p = new PrintWriter(socket.getOutputStream(), true);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.startsWith("SUBMIT-ID")) {
                    assertEquals("SUBMIT-ID",line);
                    p.println(3);
                } else if (line.startsWith("SUBMIT-IP")) {
                    assertEquals("SUBMIT-IP",line);
                    p.println("localhost");
                } else if (line.startsWith("SUBMIT-PORT")){
                    assertEquals("SUBMIT-PORT",line);
                    p.println(3); 
                    socket.close();
                    break;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    @Test
    public void testRegisterInfoWithDuplicateID(){
        System.out.println("registerInfoWithDuplicateID");
        User user = new User(2,"localhost",2);
        info.addInfo(user);
        Thread mockServer = new Thread() {
            public void run() {
                Socket myServerSocket = null;
                try {
                    ServerSocket myServer = new ServerSocket(3000);
                    System.out.println("testRegisterInfo- server socket created.");
                    myServerSocket = myServer.accept();
                    Handler handler = new Handler(myServerSocket,info,display);
                    System.out.println("testRegisterInfo- server socket connected.");
                    out = new PrintWriter(myServerSocket.getOutputStream(), true);
                    in = new Scanner(myServerSocket.getInputStream());
                    handler.registerInfo(out, in);
                    myServer.close();
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        
        mockServer.start();
        try {
            Socket socket = new Socket("localhost",3000);
            Scanner s = new Scanner(socket.getInputStream());
            PrintWriter p = new PrintWriter(socket.getOutputStream(), true);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.startsWith("SUBMIT-ID")) {
                    assertEquals("SUBMIT-ID",line);
                    p.println(2);
                } else if (line.startsWith("SUBMIT-IP")) {
                    assertEquals("SUBMIT-IP",line);
                    p.println("localhost");
                } else if (line.startsWith("SUBMIT-PORT")){
                    assertEquals("SUBMIT-PORT",line);
                    p.println(4);
                } else {
                    assertEquals("DUPLICATE-ID",line);
                    System.out.println("DuplicateId tested for");
                    socket.close();
                    break;
                }
                }
        } catch (Exception e){
            System.out.println(e);
        }
        
    }

    /**
     * Test of processMessages method, of class Handler.
     */
    @Test
    public void testProcessMessages() {
        System.out.println("processMessages");
        Thread mockServer = new Thread() {
            public void run() {
                Socket myServerSocket = null;
                try {
                    ServerSocket myServer = new ServerSocket(3000);
                    System.out.println("testRegisterInfo- server socket created.");
                    myServerSocket = myServer.accept();
                    Handler handler = new Handler(myServerSocket,info,display);
                    System.out.println("testRegisterInfo- server socket connected.");
                    out = new PrintWriter(myServerSocket.getOutputStream(), true);
                    in = new Scanner(myServerSocket.getInputStream());
                    String message = handler.processMessages(in);
                    assertEquals("testMessage",message);
                    myServer.close();
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        mockServer.start();
        
        try {
            Socket socket = new Socket("localhost",3000);
            PrintWriter p = new PrintWriter(socket.getOutputStream(), true);
            p.println("testMessage");
            socket.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    
    
}
