import java.util.ArrayList;
import java.util.Random;

public class Race {
    
    private float startTime;
    private int id;
    private static int lastId = 0;
    private ArrayList<Driver> drivers = new ArrayList<Driver>();

    Race() {
        this.id = ++lastId;
        System.out.println("Created new Race with ID number of: " + id);
    }

    Race(float startTime) {
        this();
        this.startTime=startTime;
    }

    void setStartTime(float time) {
        this.startTime = time;
    }

    float getStartTime() {
        return startTime;
    }

    public int getId() {
        return id;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }
    
    void scheduleRace()
    {
    	Random ran = new Random();
        int time = ran.nextInt(8)+1;
        
        System.out.println("\nScheduled Race at " + time + ":00 PM");
    }
    
}
