public class Kart {

    private int kartNumber;
    private static int kartLimit = 12;

    Kart() {
        System.out.println("Kart was created"); //test string
    }

    Kart(int kartNumber) {
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


}
