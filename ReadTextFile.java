import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barrerai9
 */
public class ReadTextFile {
    
   public static void main(String[] args) throws Exception
  {
    // pass the path to the file as a parameter
    //change the file path to find the text wherever it's download  

    FileReader readfile =
      new FileReader("C:\\Users\\barrerai9\\Documents\\NetBeansProjects\\GoKartDemo\\src\\ClientInformation.txt");
 
    int i;
    while ((i=readfile.read()) != -1) 
      System.out.print((char) i);
  }
    
}
