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
    ExecutorService pool = Executors.newFixedThreadPool(500);
    Receiver listener;
    Display1 display;
    
    
    public ThreadPool(Receiver listener, Display1 display){
        this.listener = listener;
        this.display = display;
    }
    
    public void run() {
        try (ServerSocket socket = new ServerSocket(listener.getPort())) {
            System.out.println("Your server is running...");
                while (true) {
                    pool.execute(new Handler(socket.accept()));
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(display, "Your server hasn't been set up successfully, please close and try again");
            }
    }
}
