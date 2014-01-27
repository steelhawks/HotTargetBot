/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import edu.wpi.first.wpilibj.templates.RobotTemplate;
//import java.util.logging.Level;
//import java.util.logging.Logger;


/**
 *
 * @author Marcus
 */
public class NetTableListener implements ITableListener {
    public static void main (String [] args){
        new NetTableListener().run();
        }
    public void run(){
        NetworkTable.setClientMode();
        NetworkTable.setIPAddress("10.26.01.2");
        RobotTemplate.nettable.addTableListener(this); 
        
        try {
            Thread.sleep(100000);
        }
        catch (InterruptedException ex){
            //Logger.getLogger(NetTableListener.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("oh crap");
        }
        }
    //@Override
    public void valueChanged(ITable itable, String string, Object o, boolean bln){
        if(string.equals("HOT") && o.toString().equals("1")){
                RobotTemplate.launch.start();
        }
    }
    
}
