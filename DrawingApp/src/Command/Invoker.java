/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

import java.util.Stack;

/**
 *
 * @author Davide
 */
public class Invoker {
    
     private Command command;
    private Stack<Command> stack = new Stack<>();
    
    public void setCommand(Command command){
        this.command = command;
    }
    
    public void startCommand(){
        command.execute();
        stack.add(command);
    }
    
    public void startUndo(){
    
        Command commandUndo = stack.pop();
        commandUndo.undo();
    }

    
}
