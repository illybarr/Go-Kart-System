import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

//this method cannot run until implemented in the main class in Client

public class VerifyLiability {

    public void verifyLiability() throws FileNotFoundException, IOException
    {
    	String inputAnswer;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nDrivers must read this Liability Form first:");
        
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
            Driver readDatabase = new Driver();
            readDatabase.readExistingMembers();
            
        }
        else
        {
            System.out.println("They cannot drive a go-kart.");
            System.exit(0);
        }
    }
}
