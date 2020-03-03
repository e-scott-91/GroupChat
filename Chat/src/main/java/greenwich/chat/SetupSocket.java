/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author emmascott
 */
public class SetupSocket extends Thread {
    private int port;
    private String ip;
    private int id;
    Scanner in;
    PrintWriter out;
    ReceiverManager receiver;
    UserManager info;
    Display1 display;

    public SetupSocket(User user, ReceiverManager receiver, UserManager info, Display1 display) {
        this.id = user.id;
        this.ip = user.ip;
        this.port = user.port;
        this.receiver = receiver;
        this.info = info;
        this.display = display;
    }

    public void run() {

            initialiseSocket(this.ip, this.port);
            
            //Adds the newly created PrintWriter to the list of PrintWriters that
            //the GUI's "send message" functionality sends messages through 
            info.addWriter(out);
            info.addWriterBK(id, out);
                        
            registerInfo(this.in, this.out, this.receiver);
 

    }
    
    //Create a new socket and register the PrintWriter and Scanner
    public PrintWriter initialiseSocket(String ip, int port){
        try {
            Socket socket = new Socket(ip, port);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);     
        } catch (IOException e){
            JOptionPane.showMessageDialog(display, "Your connection was not successful, please try adding the user again using the AddFriend button");
        }

        return out;
    }

 
    //Provides the users details to the user they are connecting with
    //and catches the error if they are trying to register a used id
    public void registerInfo(Scanner in, PrintWriter out, ReceiverManager receiver){
        while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.startsWith("SUBMIT-ID")) {
                    out.println(receiver.getRecId());
                } else if (line.startsWith("SUBMIT-IP")) {
                    out.println(receiver.getRecIp());
                } else if (line.startsWith("SUBMIT-PORT")){
                    out.println(receiver.getRecPort());       
                } else if (line.startsWith("DUPLICATE-ID")){
                    JOptionPane.showMessageDialog(display, "Someone else already has your id, please leave and try again with another id");
                }
            }
    }

}
