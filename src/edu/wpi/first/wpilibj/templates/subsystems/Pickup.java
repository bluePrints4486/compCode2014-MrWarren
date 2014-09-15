/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.PickupManual;





public class Pickup extends Subsystem {
    
    Talon pickup1 = new Talon(RobotMap.Pickup_Talon_1);
    Talon pickup2 = new Talon(RobotMap.Pickup_Talon_2); 
    RobotDrive pickup = new RobotDrive(pickup1,pickup2);
    DigitalInput lowerSwitch = new DigitalInput(RobotMap.Pickup_Lower_Stop);
    DigitalInput upperSwitch = new DigitalInput(RobotMap.Pickup_Upper_Stop);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void pickupControl(){
        pickup.setMaxOutput(.85);
        
            pickup.setLeftRightMotorOutputs(OI.systemsJoystick.getY(), -OI.systemsJoystick.getY());
        
    }
    
    public boolean lower(){
        if(lowerSwitch.get()){
            pickup.setLeftRightMotorOutputs(RobotMap.pickupLowerSpeed, -RobotMap.pickupLowerSpeed);
        }else{
            pickup.setLeftRightMotorOutputs(0, 0);
            return true;
        }
        return false;
    }
    
    public boolean raise(){
        //System.out.println("Pickup Upper"+upperSwitch.get());
        
        if(upperSwitch.get()){
            pickup.setLeftRightMotorOutputs(-RobotMap.pickUPraiseSpeen, RobotMap.pickUPraiseSpeen);
            
        }else{
            pickup.setLeftRightMotorOutputs(0, 0);
            System.out.println("UPPER PICKUP");
            return true;
        }
        return false;
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new PickupManual());
    }
}
