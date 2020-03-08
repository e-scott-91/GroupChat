/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author emmascott
 */
public interface IHandler {
    
    public void systemSetUp(Socket socket);
    
    public void registerInfo(PrintWriter out, Scanner in);
    
    public String processMessages(Scanner in);
    
    public void displayMessages(String message);
    
    public void removeUser();
    
    public void reassignCoordinator(int id);
    
    
}
