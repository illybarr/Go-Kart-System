import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//this method cannot run until implemented in the main class in Client

public class VerifyLiability {

    public void verifyLiability() throws FileNotFoundException
    {
    	String inputAnswer;
        int inputDrivers;

        Employee kart1 = new Employee();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Drivers must read this Liability Form first:");
        
        System.out.println("       I HAVE READ THIS RELEASE AND WAIVER OF LIABILITY, ASSUMPTION OF RISK AND\n" +
                           "       INDEMNITY AGREEMENT, AND UNDERSTAND THAT BY SIGNING IT I GIVE UP SUBSTANTIAL\n" +
                           "       RIGHTS I WOULD OTHERWISE HAVE TO RECOVER DAMAGES FOR LOSSES OCCASIONED BY\n" +
                           "       THE FAULT OF THE RELEASED PARTIES OR ANY OF THEM, AND SIGN IT VOLUNTARILY AND\n" +
                           "       WITHOUT ANY INDUCEMENT, ASSURANCE OR GUARANTEE BEING MADE, AND INTEND THIS\n" +
                           "       AGREEMENT TO BE A COMPLETE AND UNCONDITIONAL RELEASE OF ALL LIABILITY TO THE\n" +
                           "       GREATEST EXTENT ALLOWED BY LAW. ");
        
        //answers must be written exactly like explained or it wont run
        System.out.println("Have all the drivers accepted liability? Types 'yes' or 'no':");
        inputAnswer = sc.nextLine();
        
        if ("yes".equals(inputAnswer))
        {
            System.out.println("How many total people are driving go-karts?");
            inputDrivers = sc.nextInt();
            
          
            //change the path to wherever the textfile is located on YOUR computer
            Scanner readFile = new Scanner(new File("C:\\Users\\Iliana\\Music\\Go-Kart-System-master\\src\\ClientInformation.txt"));
 
             int count = 0;
             int kartCount = 1;
             String[] values = new String[12];
             
             while(readFile.hasNext())
             {
                 values[count] = readFile.nextLine();
                 count++;
             }
             
            System.out.println("Here is the customer information \nof the customers who can drive ");
            System.out.println("and the karts assigned to each:");
            System.out.println("---------------------------------------");
            for(int x=0; x<inputDrivers; x++)
            {
                System.out.println(values[x] + " - #" + kartCount);
                kartCount++;
            }
            
            kart1.scheduleRace();			//this should be implemented in the main class of the Server
            									//so it can be called by the Client
            
            
            
            readFile.close();
        }
        else
        {
            System.out.println("They cannot drive a go-kart.");
            System.exit(0);
        }
    }
}
