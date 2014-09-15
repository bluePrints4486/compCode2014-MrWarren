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
 * 
 * MrWarren - previously this class was named ShifterSub. It would be ok to
 * have all subsystems have the suffix of "Sub" if you wanted to so that you
 * could easily tell that a ShifterSub class was subsystem. However, only a
 * couple of subsystems had "Sub" as a suffix. So this class was renamed
 * to be "Shifter" to be consistent with the naming convention of other
 * subsystems.
 */
public class Shifter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    // MrWarren - previously the shifterRelay was initialized here. It is
    // better to have a constructor method where all variables are initialized.
    // In addition, this property has been declared private to make sure
    // that only the methods of this class have access to the relay.
    private Relay shifterRelay = null;

    /**
     * 
     * MrWarren - Previously the relay was always created using the same port
     * number. This would cause an error if more than one Shifter class was
     * instantiated (created). It is better to have the constructor take an
     * argument for the port number to use for the relay.
     * 
     * @param name - the name to use for this subsystem in SmartDashboard
     * @param relayPortNumber - the relay port number on the digital sidecar
     */
    public Shifter(String name, int relayPortNumber) {
        // MrWarren - call the parent constructor with the name provided so
        // that this instance of the Shifter object will show up with this
        // name when put into SmartDashboard.
        super(name);
        
        shifterRelay = new Relay(relayPortNumber, Relay.Direction.kBoth);
    }
    
    // MrWarren - standard java practice is to have method names be in CamelCase
    // starting with a lower case letter. CamelCase is the practice of writing
    // compound words or phrases such that each next word or abbreviation
    // begins with a capital letter.
    public void shiftLow(){
        shifterRelay.set(Relay.Value.kForward);
    }

    // MrWarren - standard java practice is to have method names be in CamelCase
    // starting with a lower case letter. CamelCase is the practice of writing
    // compound words or phrases such that each next word or abbreviation
    // begins with a capital letter.
    public void shiftHigh(){
        shifterRelay.set(Relay.Value.kReverse);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // example: setDefaultCommand(new MySpecialCommand
        
        // MrWarren - previously the default command was set to ShiftLow.
        // However, because the shifter relay retains its state, and the ShiftLow
        // command was made to exit immediately after shifting, setting it
        // as the default command could cause it to execute over and over again
        // which could be inefficient. So it is better in this case to not
        // have a default command and just let the subsystem go idle and not
        // have a currently executing command
    }
}
