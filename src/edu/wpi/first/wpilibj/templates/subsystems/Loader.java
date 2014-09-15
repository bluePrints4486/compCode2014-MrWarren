/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CatapultFree;
import edu.wpi.first.wpilibj.templates.commands.CatapultIdle;
import edu.wpi.first.wpilibj.templates.commands.CatapultManual;


public class Loader extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Talon loaderTalon = new Talon(RobotMap.Loader_Talon);
    DigitalInput lowerEndstop = new DigitalInput(RobotMap.Launcher_Stop);
    Timer timer = new Timer();
    double loaderSpeed = 1;
    double unwindTime = 5;
    double passUnwindTime = 3;
    boolean init = true;
    
    public boolean lower(){
        if(!lowerEndstop.get()){
                loaderTalon.set(0);
                return true;
        }
        if(lowerEndstop.get()){
            loaderTalon.set(-loaderSpeed);

            
        }
        
        return false;
        
    }
    
    public void manual(boolean direction){
        if(direction){
            loaderTalon.set(-loaderSpeed);
        }else{
            loaderTalon.set(loaderSpeed);
        }
    }
    
    public void stop(){
        loaderTalon.set(0);
    }
    
    public boolean free(){
        if(init){
            timer.start();
            timer.reset();
            init = false;
        }
        
        loaderTalon.set(loaderSpeed);
        
        if(timer.get()>unwindTime){
            loaderTalon.set(0);
            timer.reset();
            timer.stop();
            init = true;
            return true;
        }
        
        return false;
      
    }
    
    public boolean pass(){
        if(init){
            timer.start();
            timer.reset();
            init = false;
        }
        loaderTalon.set(-loaderSpeed);
        if(timer.get()>passUnwindTime||!lowerEndstop.get()){
            loaderTalon.set(0);
            timer.reset();
            timer.stop();
            init = true;
            return true;
        }
        return false;
    }
        
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand
        setDefaultCommand(new CatapultIdle());

    }
}
