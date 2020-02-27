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
public class Coordinator {
    private static User coordinator;
    private static Coordinator instance;
    private static Display1 display = Display1.getInstance();
    
    private Coordinator(){

    }
    
    public static Coordinator getInstance(){
        if (instance == null)
            instance = new Coordinator();
        return instance;   
    }
    
    public void setCoordinator(User user){
        this.coordinator = user;
        display.coordId.setText(Integer.toString(user.id));
        display.coordIp.setText(user.ip);
        display.coordPort.setText(Integer.toString(user.port));
    }
    
    public User getCoordinator(){
        return this.coordinator;
    }

}
