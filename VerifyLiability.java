import java.util.Scanner;
import java.io.*;

public class VerifyLiability {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        String inputAnswer;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Drivers must read this Liability Form:");
        
        System.out.println("       I HAVE READ THIS RELEASE AND WAIVER OF LIABILITY, ASSUMPTION OF RISK AND\n" +
                           "       INDEMNITY AGREEMENT, AND UNDERSTAND THAT BY SIGNING IT I GIVE UP SUBSTANTIAL\n" +
                           "       RIGHTS I WOULD OTHERWISE HAVE TO RECOVER DAMAGES FOR LOSSES OCCASIONED BY\n" +
                           "       THE FAULT OF THE RELEASED PARTIES OR ANY OF THEM, AND SIGN IT VOLUNTARILY AND\n" +
                           "       WITHOUT ANY INDUCEMENT, ASSURANCE OR GUARANTEE BEING MADE, AND INTEND THIS\n" +
                           "       AGREEMENT TO BE A COMPLETE AND UNCONDITIONAL RELEASE OF ALL LIABILITY TO THE\n" +
                           "       GREATEST EXTENT ALLOWED BY LAW. ");
        
        System.out.println("Have the drivers accepted liability? Types 'yes' or 'no':");
        
        inputAnswer = sc.nextLine();
        
        if ("yes".equals(inputAnswer))
        {
            System.out.println("\nHere are all the people who can drive: ");
            //change the path to wherever the textfile is located 
            FileReader readfile =
            new FileReader("C:\\Users\\barrerai9\\Documents\\NetBeansProjects\\GoKartDemo\\src\\ClientInformation.txt");
 
             int i;
             while ((i=readfile.read()) != -1) 
             System.out.print((char) i);
            
        }
        else
        {
            System.out.println("You cannot drive a go-kart.");
            System.exit(0);
        }
           
    }
    
}
