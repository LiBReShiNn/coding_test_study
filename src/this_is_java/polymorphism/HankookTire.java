package this_is_java.polymorphism;

public class HankookTire extends Tire{

    public HankookTire(int maxRotation, String location) {
        super(maxRotation, location);
    }

    @Override
    public boolean roll() {
        ++accumulateedRotatoin;
        if (accumulateedRotatoin < maxRotation) {
            System.out.println("HankookTire Exp : " + (maxRotation - accumulateedRotatoin));
            return true;
        } else {
            System.out.println("HankookTire Punk");
            return false;
        }
    }
}
