package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.CompressorSub;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.Launcher;
import edu.wpi.first.wpilibj.templates.subsystems.Pickup;
import edu.wpi.first.wpilibj.templates.subsystems.Shifter;
import edu.wpi.first.wpilibj.templates.subsystems.Loader;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    // Create a single static instance of all of your subsystems
    public static DriveTrain drive = new DriveTrain();
    
    // MrWarren - previously the instance of the CompressorSub subsystem was
    // named "compressor". It is better practice to have instance of objects be
    // named as a noun. Then the methods on that instance are a verb. So, in
    // this case, the subsystem should be named compressor, and an example
    // method would be compressor.
    public static CompressorSub compressor = new CompressorSub("Compressor",
            RobotMap.Compressor_Spike,
            RobotMap.Compressor_Switch);
    
    // MrWarren - previously the instance of the Shifter subsystem was named "shifter"
    // It is better practice to have instance of objects be named as a noun.
    // Then the methods on that instance are a verb. So, in this case, the
    // subsystem should be named shifter, and an example method would be shiftHigh.
    public static Shifter shifter = new Shifter("Shifter", RobotMap.SHIFTER_SPIKE);
    public static Pickup pickup = new Pickup();
    public static Launcher launcher = new Launcher();
    public static Loader loader = new Loader();
    
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(drive);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
