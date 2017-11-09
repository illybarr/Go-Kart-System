
public class Driver extends Race{
    
    private String name;
    private long phoneNumber;

    private Race assignedRace;

    Driver() {

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
