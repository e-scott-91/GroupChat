/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author emmascott
 */
public interface ISetupSocket {
    
    public PrintWriter initialiseSocket(String ip, int port);
        
   public void registerInfo(Scanner in, PrintWriter out, ReceiverManager receiver);
   
}
