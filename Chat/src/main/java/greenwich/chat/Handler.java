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
import java.util.Arrays;
import java.util.Calendar;
import java.util.NoSuchElementException;
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
    private GroupInfo info;
    private Display1 display;


    public Handler(Socket socket, GroupInfo info, Display1 display) {
        this.socket = socket;
        this.info = info;
        this.display = display;
        
    }

    public void run() {
        try {

            systemSetUp(this.socket);

            Receiver server = Receiver.getInstance();

            registerInfo(out, in);
            
            while (true) {
                
                String message = processMessages(in);
                displayMessages(message);

            }

        } catch (NoSuchElementException e) {
            System.out.println("A user has left");
        } catch (Exception e){
            System.out.println(e);
        } finally {
            removeUser();
        }
    }

    public void systemSetUp(Socket socket) {
        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registerInfo(PrintWriter out, Scanner in) {
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
                    User friend = new User(id, ip, port);
                    info.addInfo(friend);
                    break;
                } else {
                    out.println("DUPLICATE-ID");
                    break;
                }
            }
        }
    }

    public String processMessages(Scanner in) {
        String input = in.nextLine();
        return input;
    }

    public void displayMessages(String message) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat timeOnly = new SimpleDateFormat("HH:mm:ss");
        display.textArea.append(timeOnly.format(cal.getTime()) + " - USER " + id + " : " + message + "\n");
    }

    public void removeUser() {
        Coordinator coordinator = Coordinator.getInstance();
        if (id != null) {
            User friend = new User(id, ip, port);
            info.removeInfo(friend);
            info.removeSendToInfo(friend);
            display.textArea.append("USER " + id + " has left" + "\n");
            
            if (id == coordinator.getCoordinator().id){
                Object[] objIds = info.getIds().toArray();
                Integer[] intIds = new Integer[objIds.length];
                for (int i = 0; i < objIds.length; i++){
                    intIds[i] = (Integer)objIds[i];
                }
                int highestId = 0;
                for (int i = 0; i < intIds.length; i++){
                    if (intIds[i]> highestId){
                        highestId = intIds[i];
                    }               
                }
                
                coordinator.setCoordinator(info.getUserById(highestId));
            }
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Unable to close the socket");
        }
    }

}
