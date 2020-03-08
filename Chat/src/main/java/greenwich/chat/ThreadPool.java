/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;

/**
 *
 * @author emmascott
 */
public class ThreadPool extends Thread {
    ExecutorService pool = Executors.newFixedThreadPool(50);
    ReceiverManager listener;
    UserManager info;
    
    
    public ThreadPool(ReceiverManager listener, UserManager info){
        this.listener = listener;
        this.info = info;
    }
    
    public void run() {
        //Create a new ServerSocket with the port number given as a commandline argument
        try (ServerSocket socket = new ServerSocket(listener.getReceiver().port)) {
            System.out.println("Your server is running...");
                //Runs continuously waiting for sockets to connect to the server
                while (true) {
                    pool.execute(new Handler(socket.accept(),info,ChatDisplay.getInstance()));
                    if (pool.isShutdown())
                        break;
                    
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Your server hasn't been set up successfully. Please close and try again");
            }
    }
}
