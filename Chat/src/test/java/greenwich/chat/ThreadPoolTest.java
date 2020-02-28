/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.net.ServerSocket;
import java.net.Socket;
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
public class ThreadPoolTest {
    GroupInfo info = GroupInfo.getInstance();
    Display1 display = Display1.getInstance();
    Receiver listener = Receiver.getInstance();
    ThreadPool threadPool = new ThreadPool(listener,info,display);
    
    public ThreadPoolTest() {
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

    /**
     * Test of run method, of class ThreadPool.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        User self = new User(1,"localhost",3000);
        listener.setReceiver(self);
        Thread thread = new Thread() {
            public void run() {
                try {       
                    threadPool.run();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        thread.start();
        
        try {
            Socket socket = new Socket("localhost",3000);
            assertTrue(socket.isConnected());
            System.out.println("Connected");
            socket.close();
            threadPool.pool.shutdown();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
}
