/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ShiftHigh;
import edu.wpi.first.wpilibj.templates.commands.ShiftLow;

/**
 *
 * @author Developer
 */
public class ShiftersSub extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Relay shifterRelay = new Relay(RobotMap.SHIFTER_SPIKE,Relay.Direction.kBoth);
    
    public void ShiftLow(){
        shifterRelay.set(Relay.Value.kForward);
    }

    public void ShiftHigh(){
        shifterRelay.set(Relay.Value.kReverse);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand
        setDefaultCommand(new ShiftLow());
        
    }
    
    
    
}
