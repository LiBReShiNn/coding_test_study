package this_is_java.polymorphism;

public class KumhoTire extends Tire{

    public KumhoTire(int maxRotation, String location) {
        super(maxRotation, location);
    }

    @Override
    public boolean roll() {
        ++accumulateedRotatoin;
        if (accumulateedRotatoin < maxRotation) {
            System.out.println("KumhoTire Exp : " + (maxRotation - accumulateedRotatoin));
            return true;
        } else {
            System.out.println("KumhoTire Punk");
            return false;
        }
    }
}
