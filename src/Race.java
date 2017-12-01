import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalTime;

public class Race {
    
    private LocalTime startTime;
    private static LocalTime firstRaceTime = LocalTime.now();
    private int id;
    private static int lastId = 0;
    private ArrayList<Driver> drivers = new ArrayList<Driver>();

    Race() {
        this.id = ++lastId;
        firstRaceTime = firstRaceTime.plusMinutes(20);
        startTime = firstRaceTime;
        System.out.println("Created new Race with ID number of " + id + " and starting time of " + getStartTimeSttring());
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public String getStartTimeSttring() {
        String timeString = startTime.toString();
        return timeString.substring(0, timeString.lastIndexOf(':'));
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
