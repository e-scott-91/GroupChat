/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author emmascott
 */
public class ThreadPool extends Thread {
    ExecutorService pool = Executors.newFixedThreadPool(500);
    Receiver listener;
    GroupInfo info;
    Display1 display;
    
    
    public ThreadPool(Receiver listener, GroupInfo info, Display1 display){
        this.listener = listener;
        this.display = display;
        this.info = info;
    }
    
    public void run() {
        try (ServerSocket socket = new ServerSocket(listener.getPort())) {
            System.out.println("Your server is running...");
                while (true) {
                    pool.execute(new Handler(socket.accept(),info,display));
                    if (pool.isShutdown())
                        break;
                    
                }
            } catch (Exception e){
                System.out.println("Your server has not been set up successfully");
            }
    }
}
