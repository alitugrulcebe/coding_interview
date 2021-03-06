package MySolutions.SOLID.interface_segregation.bad.src;

/**
 * Created by mrk on 4/7/14.
 */
public class Eagle implements Bird {
    public String currentLocation;
    public int numberOfFeathers;

    public Eagle(int initialFeatherCount) {
        this.numberOfFeathers = initialFeatherCount;
    }

    public void fly() {
        this.currentLocation = "in the air";
    }

    public void molt() {
        this.numberOfFeathers -= 1;
    }
}
