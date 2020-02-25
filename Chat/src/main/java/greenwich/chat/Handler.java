/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author emmascott
 */
public class Handler implements Runnable {
    private Integer id;
    private String ip;
    private Integer port;
    private Socket socket;
    private Scanner in;
    private PrintWriter out;

    
    // The set of all the print writers for all the clients, used for broadcast.
    //private static Set<PrintWriter> writers = new HashSet<>();
    
    GroupInfo info = GroupInfo.getInstance();
    Display1 display = Display1.getInstance();
    
    public Handler(Socket socket) {
            this.socket = socket;
        }
    
    public void run()  {
            try {
                
                systemSetUp(this.socket);
                
                Receiver server = Receiver.getInstance();
                
                registerInfo(out, in);
                
                processMessages(in);
                           
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                removeUser();
            }       
}

    public void systemSetUp(Socket socket){
        try{
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void registerInfo(PrintWriter out, Scanner in){
        // Keep requesting an id until we get a unique one.
        while (true) {
                    out.println("SUBMIT-ID");
                    id = Integer.parseInt(in.nextLine());
                    out.println("SUBMIT-IP");
                    ip = in.nextLine();
                    out.println("SUBMIT-PORT");
                    port = Integer.parseInt(in.nextLine());
                    synchronized (info) {
                        if (!info.getIds().contains(id)) {
                            User friend = new User(id,ip,port);
                           info.addInfo(friend);
                           System.out.println(ip);
                            break;
                        }
                    }    
                }
    }
    
    public void processMessages(Scanner in){
        while (true) {
                    String input = in.nextLine();
                    if (input.toLowerCase().startsWith("/quit")) {
                        return;
                    }
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat timeOnly = new SimpleDateFormat("HH:mm:ss");
                    display.textArea.append(timeOnly.format(cal.getTime()) + " - USER " + id + " : " + input + "\n");
                }
    }
    
    public void removeUser(){
        if (id != null) {
                    User friend = new User(id,ip,port);
                    info.removeInfo(friend);
                    info.removeSendToInfo(friend);
                    display.textArea.append("USER " + id + " has left" + "\n");
                }
                try { socket.close(); } catch (IOException e) {}
    }
    
}
