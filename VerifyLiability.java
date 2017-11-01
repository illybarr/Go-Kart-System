/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barrerai9
 */
import java.util.Scanner;

public class VerifyLiability {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String inputAnswer;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Read this Liability Form:");
        
        System.out.println("       I HAVE READ THIS RELEASE AND WAIVER OF LIABILITY, ASSUMPTION OF RISK AND\n" +
                           "       INDEMNITY AGREEMENT, AND UNDERSTAND THAT BY SIGNING IT I GIVE UP SUBSTANTIAL\n" +
                           "       RIGHTS I WOULD OTHERWISE HAVE TO RECOVER DAMAGES FOR LOSSES OCCASIONED BY\n" +
                           "       THE FAULT OF THE RELEASED PARTIES OR ANY OF THEM, AND SIGN IT VOLUNTARILY AND\n" +
                           "       WITHOUT ANY INDUCEMENT, ASSURANCE OR GUARANTEE BEING MADE, AND INTEND THIS\n" +
                           "       AGREEMENT TO BE A COMPLETE AND UNCONDITIONAL RELEASE OF ALL LIABILITY TO THE\n" +
                           "       GREATEST EXTENT ALLOWED BY LAW. ");
        
        System.out.println("Do you agree to accept all liability? Types 'yes' or 'no':");
        
        inputAnswer = sc.nextLine();
        
        if ("yes".equals(inputAnswer))
            System.out.println("You can be assigned to a go-kart.");
        else
        {
            System.out.println("You cannot drive.");
            System.exit(0);
        }
           
    }
    
}
