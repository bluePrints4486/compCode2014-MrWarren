/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CompressorManager;

/**
 *
 * @author Developer
 */
public class CompresserSub extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //Compressor compress = new Compressor(RobotMap.Compressor_Switch, RobotMap.Compressor_Spike);
    Relay compress = new Relay(RobotMap.Compressor_Spike);
    DigitalInput compressorSwitch = new DigitalInput(RobotMap.Compressor_Switch);
    
    public void compress(){
        if(!compressorSwitch.get()){
            compress.set(Relay.Value.kForward);
        }else if(compressorSwitch.get()){
            compress.set(Relay.Value.kOff );
        }
        
    
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        setDefaultCommand(new CompressorManager());
        
    }
    
    
    
    
    
    
}
