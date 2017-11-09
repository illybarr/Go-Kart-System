
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
    
}
