/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barrerai9
 */

import java.util.Random;

public class Employee {

    String name;
    int ID;
    
    public Employee()
    {
    	
    }

    public Employee(String name)
    {
        this.name=name;
    }

    public Employee(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    void scheduleRace()
    {
    	Random ran = new Random();
        int time = ran.nextInt(8)+1;
        
        System.out.println("\nScheduled Race at " + time + ":00 PM");
    }

}
