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
    Receiver receiver;
    GroupInfo info;
    Display1 display;

    public SetupSocket(User user, Receiver receiver, GroupInfo info, Display1 display) {
        this.id = user.id;
        this.ip = user.ip;
        this.port = user.port;
        this.receiver = receiver;
        this.display = display;
        this.info = info;
    }

    public void run() {
        try {
            System.out.println("You're connected");
            Socket socket = new Socket(ip, port);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            info.addWriter(out);
            info.addWriterBK(id, out);

            
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.startsWith("SUBMIT-ID")) {
                    out.println(receiver.getId());
                } else if (line.startsWith("SUBMIT-IP")) {
                    out.println(receiver.getIp());
                } else if (line.startsWith("SUBMIT-PORT")){
                    out.println(receiver.getPort());       
                } else if (line.startsWith("MESSAGE")) {
                    //display.textArea.append(line.substring(8) + "\n");
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(display, "Your connection wasn't successful");
        }

    }
}
