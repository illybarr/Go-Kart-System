/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barrerai9
 */
public class TrackSupervisor extends Employee{
    
    public TrackSupervisor()
    {
    }
    
    void deleteDriver(Driver[] temp, Driver deletedClient)
    {
        //revise and double-check
        Driver[] transfer = new Driver[12];
        int counter=0;
        
        for(int x=0; x<temp.length; x++)
        {
            if(temp[x].equals(deletedClient))
            {
                transfer[counter++] = temp[x];
            }
        }
        
        temp = transfer;
    }
    
}
