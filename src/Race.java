import java.util.Random;

public class Race {
    
    private float startTime;
    private Driver[] drivers;
    

    Race() {

    }

    Race(float startTime) {
        this.startTime=startTime;
    }
    
    void setStartTime(float time) {
        this.startTime = time;
    }

    float getStartTime() {
        return startTime;
    }
    
    void scheduleRace()
    {
    	Random ran = new Random();
        int time = ran.nextInt(8)+1;
        
        System.out.println("\nScheduled Race at " + time + ":00 PM");
    }
    
}
