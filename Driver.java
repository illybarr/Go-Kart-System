
public class Driver {
    
    public String name;
    public long phoneNumber;
    public Race assignedRace;

    Driver() {
        System.out.println("Driver was created.");    //test string
    }

    Driver(String name) 
    {
            this.name=name;
    }

    Driver(String name, long number) 
    {
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
    
}
