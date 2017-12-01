public class Kart {

    private int kartNumber;
    private static int lastKartNumber = 0;
    private Driver driver;
    public static int kartLimit = 12;

    Kart() {
        kartNumber = ++lastKartNumber;
        //System.out.println("A new Kart was created with number " + kartNumber);
    }

    Kart(int kartNumber) {
        this();
        this.kartNumber = kartNumber;
    }

    public int getKartNumber() {
        return kartNumber;
    }

    public void setKartNumber(int kartNumber) {
        this.kartNumber = kartNumber;
    }

    public int getKartLimit() {
        return kartLimit;
    }

    public void setKartLimit(int kartLimit) {
        Kart.kartLimit = kartLimit;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }
}
