
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Driver {

    private String name;
    private long phoneNumber;
    private int id;
    private static int lastId = 0;
    private Race assignedRace;
    private Kart assignedKart;

    public static int inputDrivers;

    Driver() {
        this.id = ++lastId;
        System.out.println("Created new Driver with ID number of: " + id);
    }

    Driver(String name)
    {
        this();
        this.name=name;
    }

    Driver(String name, long number)
    {
        this();
        this.name = name;
        this.phoneNumber = number;
    }

    String getName()
    {
        return name;
    }

    void setName(String name)
    {
            this.name=name;
    }

    long getPhoneNumber()
    {

        return phoneNumber;
    }

    void setPhoneNumber(long number)
    {
        this.phoneNumber=number;
    }

    public void setAssignedRace(Race race) {
        assignedRace = race;
    }

    public Race getAssignedRace() {
        return assignedRace;
    }

    public void setAssignedKart(Kart kart) {
        assignedKart = kart;
    }

    public Kart getAssignedKart() {
        return assignedKart;
    }

    public int getId() {
        return id;
    }

    void readExistingMembers() throws FileNotFoundException
    {
        //CHANGE the path to wherever the textfile is located on YOUR computer
            Scanner readFile = new Scanner(new File("src/ClientInformation.txt"));
 
            Scanner sc = new Scanner(System.in);
            Random ran = new Random();
            
            System.out.println("How many total people are driving go-karts?");
            inputDrivers = sc.nextInt();
            
             int count = 0;
             int kartCount = 1;
             String[] values = new String[12];
             double[] times = {58.742, 57.69, 49.041, 50.108, 43.403, 44.846, 57.574, 53.514, 43.644, 53.234, 45.113, 56.258};
             
             while(readFile.hasNext())
             {
                 values[count] = readFile.nextLine();
                 count++;
             }

            //schedule a race time for the existing drivers
            Employee kart1 = new Employee();   
            kart1.scheduleRace();
            System.out.println("");
                       
            
           System.out.println("Names\t\t\t Phone Number   KartNumber   Race Times");
           System.out.println("---------------------------------------------------");
           Arrays.sort(times, 0, inputDrivers);
            
           for(int x=0; x<inputDrivers; x++)
           {
               System.out.println(values[x] + "   #" + kartCount+ "   " + times[x]);
               kartCount++;
           }
            
           //sc.close();
           //readFile.close();
                                                                                
    }

}
