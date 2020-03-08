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
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author emmascott
 */
public class Handler implements Runnable, IHandler {

    private Integer id;
    private String ip;
    private Integer port;
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private UserManager info;
    private ChatDisplay display;

    public Handler(Socket socket, UserManager info, ChatDisplay display) {
        this.socket = socket;
        this.info = info;
        this.display = display;

    }

    public void run() {
        try {

            systemSetUp(this.socket);

            registerInfo(out, in);

            //Loops continuously until the user leaves or an error occurs
            while (true) {

                String message = processMessages(in);
                displayMessages(message);

            }
            //Occurs when there is no ".nextLine" in the scanner
            //(i.e. when the user has left)
        } catch (NoSuchElementException e) {
            System.out.println("A user has left");
        } catch (Exception e) {
            System.out.println(e);
            //Runs when the user has left or if an error occurs
        } finally {
            removeUser();
            reassignCoordinator(id);
        }
    }

    //Creates new PrintWriters and Scanners for the socket provided
    public void systemSetUp(Socket socket) {
        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registerInfo(PrintWriter out, Scanner in) {
        // Requests user information from the socket trying to connect
        while (true) {
            out.println("SUBMIT-ID");
            id = Integer.parseInt(in.nextLine());
            out.println("SUBMIT-IP");
            ip = in.nextLine();
            out.println("SUBMIT-PORT");
            port = Integer.parseInt(in.nextLine());
            //Registers the user's information
            synchronized (info) {
                if (!info.getIds().contains(id)) {
                    User friend = new User(id, ip, port);
                    info.addInfo(friend);
                    break;
                    //If the id is already registered it will send a message
                    //to the user trying to connect
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

    //Adds a time stamp to the message from the scanner and displays it on the GUI
    public void displayMessages(String message) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat timeOnly = new SimpleDateFormat("HH:mm:ss");
        display.textArea.append(timeOnly.format(cal.getTime()) + " - USER " + id + " : " + message + "\n");
    }

    public void removeUser() {
        
        if (id != null) {
            User friend = new User(id, ip, port);
            info.removeInfo(friend);
            info.removeSendToInfo(friend);
            display.textArea.append("USER " + id + " has left" + "\n");

        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Unable to close the socket");
        }
    }

    public void reassignCoordinator(int id) {
        CoordinatorManager coordinatorM = CoordinatorManager.getInstance();
        //Checks to see if the user that has left is the coordinator
        //If it is, it assigns the coordinator role to the user with the highest ID
        if (id == coordinatorM.getCoordinator().id) {
            if (info.getIds() != null) {
                Object[] objIds = info.getIds().toArray();
                Integer[] intIds = new Integer[objIds.length];
                for (int i = 0; i < objIds.length; i++) {
                    intIds[i] = (Integer) objIds[i];
                }
                int highestId = 0;
                for (int i = 0; i < intIds.length; i++) {
                    if (intIds[i] > highestId) {
                        highestId = intIds[i];
                    }
                }
                coordinatorM.setCoordinator(info.getUserById(highestId));
                display.setCoordinator(info.getUserById(highestId));
            } else {
                JOptionPane.showMessageDialog(null, "Something went wrong");
            }
        }
    }

}
