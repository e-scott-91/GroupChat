/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

import java.io.PrintWriter;
import java.util.Set;

/**
 *
 * @author emmascott
 */
public interface IUserManager {
    
    public void addInfo(User user);
    
    public void removerInfo(User user);
    
    public User getUserById(int id);
    
    public void addSendToInfo(User user);
    
    public void removeSendToInfo(User user);
    
    public Set<PrintWriter> getWriters();
    
    public PrintWriter getWriterBK(int key);
    
    public void removeWriterBK(int key);
    
    public void addWriter(int key, PrintWriter writer);

}
