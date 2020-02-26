/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

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

        //InetAddress inetAddress = InetAddress.getLocalHost();
        int port = Integer.parseInt(args[1]);
        int id = Integer.parseInt(args[2]);
        Receiver listener = Receiver.getInstance();
        GroupInfo info = GroupInfo.getInstance();
        //listener.setIp(inetAddress.getHostAddress());
        listener.setIp(args[0]);
        listener.setPort(port);
        listener.setId(id);

        ThreadPool serverSetup = new ThreadPool(listener,info,display);

        if (args.length == 3) {
            serverSetup.start();
            User yourself = new User(listener.getId(),listener.getIp(),listener.getPort());
            SetupSocket self = new SetupSocket(yourself,listener,info);
            self.start();
            JOptionPane.showMessageDialog(display, "You are the group coordinator. When someone new joins, can you send them a list of "
                    + "everyone elses ips and ports");

        } else if (args.length == 6) {
            serverSetup.start();
            User coordinator = new User(Integer.parseInt(args[5]),args[3],Integer.parseInt(args[4]));
            SetupSocket link = new SetupSocket(coordinator,listener,info);
            link.start();
            info.addSendToInfo(coordinator);
            User yourself = new User(listener.getId(),listener.getIp(),listener.getPort());
            SetupSocket self = new SetupSocket(yourself,listener,info);
            self.start();
        }
        else {
            JOptionPane.showMessageDialog(display, "You entered an incorrect number of arguments, please try again");
            
        }
    }
    
}
