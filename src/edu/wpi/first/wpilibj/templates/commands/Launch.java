/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Marcus
 */
public class Launch extends CommandBase {
    //private double jagTimeout;
    public Launch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //jagTimeout = timeout;
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(0.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        chassis.launch();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        chassis.stopLaunch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
