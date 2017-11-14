import java.io.File;
import java.util.Scanner;


public class VerifyLiability {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        String inputAnswer;
        int inputDrivers;
        
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
            Scanner readFile = new Scanner(new File("C:\\Users\\barrerai9\\Documents\\NetBeansProjects\\Go-Kart System\\src\\ClientInformation.txt"));
 
             int count = 0;
             String[] values = new String[12];
             
             while(readFile.hasNext())
             {
                 values[count] = readFile.nextLine();
                 count++;
             }
             
            System.out.println("Here is the customer information \nof the customers who can drive:");
            System.out.println("---------------------------------------");
            for(int x=0; x<inputDrivers; x++)
            {
                System.out.println(values[x]);
            }
        }
        else
        {
            System.out.println("They cannot drive a go-kart.");
            System.exit(0);
        }
           
    }
    
}
