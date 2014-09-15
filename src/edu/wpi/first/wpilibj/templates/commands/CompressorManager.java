/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Developer
 */
public class CompressorManager extends CommandBase {
    
    public CompressorManager() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // MrWarren - previously the compress method was being called inside
        // of execute. That was necessary because that method was continuosly
        // checking the state of the pressure switch and controlling the relay.
        // However, now that the compress method continuously does that in
        // the background, it needs to be only called once in the initialize.
        compressor.compress();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // MrWarren - Since we want this to run forever, I agree with always
        // returning false here.
        return false;
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
