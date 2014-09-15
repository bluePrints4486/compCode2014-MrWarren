/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Developer
 */
public class ShiftLow extends CommandBase {
    
    public ShiftLow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shifter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // MrWarren - previously this command was running until interruped
        // because isFinished always returned false. Furthermore, the shiftLow
        // method was being continuously called in the execute method. Since
        // the shiftLow method is something that can done once and it will
        // hold that position, it is more efficient to call the ShiftLow method
        // in the initialize method, and then have isFinished return true. Your
        // execute method will never be called and the command will end
        // right after the initialize.
        shifter.shiftLow();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        // MrWarren - in general it is good practice to have your interrupted
        // method call your end method. That way any cleanup you have to do
        // at command completion can be in your end method and you will be sure
        // it is always executed. There may be some rare occasions where you
        // want to do something different when your code is interrupted instead
        // of ended normally.
        end();
    }
}
