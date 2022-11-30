/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author Davide
 */
public class Invoker {
    
    private Command command;
    
    public void setCommand(Command command){
        this.command = command;
    }
    
    public void startCommand(){
        command.execute();
    }
    
}
