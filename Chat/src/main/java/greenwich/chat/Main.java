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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Display1 display = Display1.getInstance();
        display.setVisible(true);
        Coordinator coordinator = Coordinator.getInstance();
        Receiver listener = Receiver.getInstance();

        
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
            listener.setIp(ip);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(display, "You are not connected to the internet");
        }
        int id = Integer.parseInt(args[0]);
        int port = Integer.parseInt(args[1]);

        GroupInfo info = GroupInfo.getInstance();
        listener.setPort(port);
        listener.setId(id);

        ThreadPool serverSetup = new ThreadPool(listener, info, display);

        if (args.length == 2) {
            serverSetup.start();
            User yourself = new User(listener.getId(), listener.getIp(), listener.getPort());
            SetupSocket self = new SetupSocket(yourself, listener, info, display);
            self.start();
            coordinator.setCoordinator(yourself);
            JOptionPane.showMessageDialog(display, "You are the group coordinator. When someone new joins, can you send them a list of "
                    + "everyone elses ips and ports");

        } else if (args.length == 5) {
            serverSetup.start();
            User firstFriend = new User(Integer.parseInt(args[2]), args[3], Integer.parseInt(args[4]));
            coordinator.setCoordinator(firstFriend);
            SetupSocket link = new SetupSocket(firstFriend, listener, info, display);
            link.start();
            info.addSendToInfo(firstFriend);
            User yourself = new User(listener.getId(), listener.getIp(), listener.getPort());
            SetupSocket self = new SetupSocket(yourself, listener, info, display);
            self.start();
        } else {
            JOptionPane.showMessageDialog(display, "You entered an incorrect number of arguments, please try again");

        }

    }

}
