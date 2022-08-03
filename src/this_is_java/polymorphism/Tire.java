package this_is_java.polymorphism;

public class Tire {
    public int maxRotation;
    public int accumulateedRotatoin;
    public String location;

    public Tire(int maxRotation, String location) {
        this.maxRotation = maxRotation;
        this.location = location;
    }

    public boolean roll() {
        ++accumulateedRotatoin;
        if (accumulateedRotatoin < maxRotation) {
            System.out.println("Tire Exp : " + (maxRotation - accumulateedRotatoin));
            return true;
        } else {
            System.out.println("Tire Punk");
            return false;
        }
    }
}
