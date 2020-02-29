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
public class CoordinatorManager  {
    private static CoordinatorManager instance;
    private static User coordinator;
    private static Display1 display = Display1.getInstance();
    
    private CoordinatorManager(){
    }
    
    public static CoordinatorManager getInstance(){
        if (instance == null)
            instance = new CoordinatorManager();
        return instance;   
    }
    
    public void setCoordinator(User coordinator){
        this.coordinator = coordinator;
        display.coordId.setText(Integer.toString(coordinator.id));
        display.coordIp.setText(coordinator.ip);
        display.coordPort.setText(Integer.toString(coordinator.port));
    }
    
    public User getCoordinator(){
        return coordinator;
    }

}
