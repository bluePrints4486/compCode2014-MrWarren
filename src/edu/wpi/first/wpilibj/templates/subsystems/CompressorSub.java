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
 * 
 * MrWarren - To match convention of other subsystems, this class should be
 * named Compressor. However, there is already a Compressor class in wpilib.
 * Therefore, it is ok to have this class named CompressorSub to prevent
 * the name conflict and to make it clear this is a subsystem. It would be even
 * better to have all of your subsystems use the "Sub" suffix.
 */
public class CompressorSub extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    // MrWarren - previously an instance of a relay and pressure
    // switch were used for controlling the compressor. However, wpilib
    // provides a Compressor class that can be used instead to control
    // the compressor using these two devices.
    //
    // This property is declared private to make sure that only the methods
    // of this class have access to it.
    private Compressor compressor = null;
    
    /**
     * 
     * MrWarren - Previously the relay and switch was always created using the same port
     * numbers. This would cause an error if more than one CompressorSub class was
     * instantiated (created). It is better to have the constructor take
     * arguments for the port numbers to use.
     * 
     * @param name - the name to use in SmartDashboard
     * @param switchPortNumber - the digital I/O port number on the digital sidecar
     * @param relayPortNumber - the relay port number on the digital sidecar
     */
    public CompressorSub(String name, int switchPortNumber, int relayPortNumber) {
        // MrWarren - call the parent constructor with the name provided so
        // that this instance of the Shifter object will show up with this
        // name when put into SmartDashboard.
        super(name);
        
        compressor = new Compressor(switchPortNumber, relayPortNumber);
    }

    /**
     * Once called, this method continously runs a background job to check the
     * pressure switch and turn the compressor on/off based on that switch.
     */
    public void compress(){
        // MrWarren - previously this method checked a pressure switch and turned
        // the relay on/off for the compressor. That required calling this
        // method repeatedly. Now that we are using a Compressor
        // object, the start method of the compressor object can be used to continuosly
        // do that checking in the background.
        compressor.start();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        setDefaultCommand(new CompressorManager());
    }
}
