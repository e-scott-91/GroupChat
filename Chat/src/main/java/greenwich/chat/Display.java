/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwich.chat;

/**
 *
 * @author emmascott
 */
public interface Display {
    
    public javax.swing.JTextArea textArea = new javax.swing.JTextArea();
    
    public void setCoordinator(User coordinator);
    
}
