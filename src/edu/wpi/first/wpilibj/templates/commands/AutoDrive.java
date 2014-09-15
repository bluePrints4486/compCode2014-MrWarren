/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author karl
 */
public class AutoDrive extends CommandBase {
    
    boolean ended = false;
    double runTime = 0;
    double speed = 0;
    double curve = 0;
    
    public AutoDrive(double time,double speed,double turn) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.runTime = time;
        this.speed = speed;
        this.curve = turn;
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ended = drive.autoDrive(runTime,speed, curve);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ended;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
