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
public class SetupSocket extends Thread implements ISetupSocket {
    private int port;
    private String ip;
    private int id;
    Scanner in;
    PrintWriter out;
    ReceiverManager receiver;
    UserManager info;

    public SetupSocket(User user, ReceiverManager receiver, UserManager info) {
        this.id = user.id;
        this.ip = user.ip;
        this.port = user.port;
        this.receiver = receiver;
        this.info = info;
    }

    public void run() {

            initialiseSocket(this.ip, this.port);
            
            //Adds the newly created PrintWriter to the list of PrintWriters that
            //the GUI's "send message" functionality sends messages through 
            info.addWriter(id, out);
                        
            registerInfo(this.in, this.out, this.receiver);
 

    }
    
    //Create a new socket and register the PrintWriter and Scanner
    public PrintWriter initialiseSocket(String ip, int port){
        try {
            Socket socket = new Socket(ip, port);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);     
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Your connection was not successful, please try adding the user again using the AddFriend button");
        }

        return out;
    }

 
    //Provides the users details to the user they are connecting with
    //and catches the error if they are trying to register a used id
    public void registerInfo(Scanner in, PrintWriter out, ReceiverManager receiver){
        while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.startsWith("SUBMIT-ID")) {
                    out.println(receiver.getReceiver().id);
                } else if (line.startsWith("SUBMIT-IP")) {
                    out.println(receiver.getReceiver().ip);
                } else if (line.startsWith("SUBMIT-PORT")){
                    out.println(receiver.getReceiver().port);       
                } else if (line.startsWith("DUPLICATE-ID")){
                    JOptionPane.showMessageDialog(null, "Someone else already has your id, please leave and try again with another id");
                }
            }
    }

}
