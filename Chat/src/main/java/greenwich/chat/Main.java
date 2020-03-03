/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author emmascott
 */
public class Main {

    public static void main(String[] args) {
        Display1 display = Display1.getInstance();
        display.setVisible(true);
        CoordinatorManager coordinator = CoordinatorManager.getInstance();
        ReceiverManager listener = ReceiverManager.getInstance();

        //Code written automatically by the JFrame form 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Display1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ip = inetAddress.getHostAddress();
            User self = new User(Integer.parseInt(args[0]), ip, Integer.parseInt(args[1]));
            listener.setReceiver(self);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(display, "You are not connected to the internet");
        }

        UserManager info = UserManager.getInstance();
        User self = listener.getReceiver();
        ThreadPool serverSetup = new ThreadPool(listener, info, display);

        //Code that runs if the user is the first to the group and only inputs their details
        if (args.length == 2) {
            //Start their server threadPool ready for connecting users
            serverSetup.start();
            SetupSocket own = new SetupSocket(self, listener, info, display);
            //Connect to their own server
            own.start();
            //Set the coordinator as themselves
            coordinator.setCoordinator(self);
            JOptionPane.showMessageDialog(display, "You are the group coordinator. When someone new joins, can you send them a list of "
                    + "everyone elses ips and ports");

            //Code that runs if the user has input the details of the coordinator and themselves
        } else if (args.length == 5) {
            //Start their server threadPool ready for connecting users
            serverSetup.start();
            try {
                //Create a user with the coordinators details and set them as the coordinator
                User firstFriend = new User(Integer.parseInt(args[2]), args[3], Integer.parseInt(args[4]));
                coordinator.setCoordinator(firstFriend);
                SetupSocket link = new SetupSocket(firstFriend, listener, info, display);
                //Connect to the coordinators server
                link.start();
                //Add the coordinator to the list of users you're connected to
                info.addSendToInfo(firstFriend);
            } catch (Exception e) {
                //Occurs if the id and port number could not be processed by parseInt
                JOptionPane.showMessageDialog(display,"The arguments that you passed were incorrect. Please close and try again");
            }
            SetupSocket own = new SetupSocket(self, listener, info, display);
            //Connect to your own server
            own.start();
        } else {
            //Code that runs if the incorrect number of parameters have been passed
            JOptionPane.showMessageDialog(display, "You entered an incorrect number of arguments, please try again");

        }

    }

}
