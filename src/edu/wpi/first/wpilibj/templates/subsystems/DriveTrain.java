
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Drive;

/**
 *
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

   
    
    Encoder leftEncoder = new Encoder(RobotMap.Left_Encoder_A,RobotMap.Left_Encoder_B);
    Encoder rightEncoder = new Encoder(RobotMap.Right_Encoder_A,RobotMap.Right_Encoder_B);
    Talon leftTalon = new Talon (RobotMap.Left_Talon) ;
    Talon rightTalon = new Talon (RobotMap.Right_Talon) ;
    RobotDrive drive = new RobotDrive (leftTalon, rightTalon);
    Timer driveTimer = new Timer();
    boolean init = true;
    
    public void drive(double left, double right){

        drive.tankDrive (-left, -right);

    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new Drive());
    }
    
    
    public boolean autoDrive(double time,double speed,double curve){
        // this will run only once in the beginning
        if(init){
            driveTimer.start();
            driveTimer.reset();
            init = false;
        }
        // drive
        drive.drive(speed, curve);
        //if out of time
        if(driveTimer.get()>time){
            init= true;
            drive.drive(0, 0);
            return true;
        }
        
        return false;
        
    }
    
    
}

