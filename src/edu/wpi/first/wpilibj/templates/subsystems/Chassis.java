/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;
//import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.Relay;
/**
 *
 * @author Marcus
 */
public class Chassis extends Subsystem {
    private Relay.Value kOn;
    private Relay.Value kOff;
    
    protected void initDefaultCommand() {
        setDefaultCommand (new Drive());
    }
    private double speed = 0.5;
    Jaguar frontLeftJag = new Jaguar(RobotMap.frontLeftMotorChannel);
    Jaguar frontRightJag = new Jaguar(RobotMap.frontRightMotorChannel);
    Jaguar rearLeftJag = new Jaguar(RobotMap.rearLeftMotorChannel);
    Jaguar rearRightJag = new Jaguar(RobotMap.rearRightMotorChannel);
    Talon kicker = new Talon(RobotMap.launcherMotorChannel);
    Relay light = new Relay(RobotMap.lightSpike);
        
    public RobotDrive mec = new RobotDrive(frontLeftJag, frontRightJag, rearLeftJag, rearRightJag);
        
    Gyro gyro = new Gyro(RobotMap.gyro);
    private final double sensitivity = 0.7;
    
    public Chassis(){
        gyro.setSensitivity(speed);
        mec.stopMotor();
    }
    public void mecanumDrive (Joystick leftStick) {
        double x = leftStick.getX();
        double y = leftStick.getY();
        double rotation = leftStick.getTwist();
        double angle = gyro.getAngle();
        mec.mecanumDrive_Cartesian(x, y, rotation, angle);
        
    }
    public void resetGyro () {
        gyro.reset();
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public void launch(){
        kicker.set(1.0);
    }
    public void stopLaunch(){
        kicker.set(0.0);
    }
    public void lightOn(){
        light.set(kOn);
    }
    public void lightOff(){
        light.set(kOff);
    }
}
