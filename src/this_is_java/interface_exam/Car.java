package this_is_java.interface_exam;

public class Car {
//
//    Tire frontLeft = new HankookTire();
//    Tire frontRight = new HankookTire();
//    Tire backLeft = new HankookTire();
//    Tire backRight = new HankookTire();
//
//    void run() {
//        frontLeft.roll();
//        frontRight.roll();
//        backLeft.roll();
//        backRight.roll();
//    }

    Tire[] tires = {
            new HankookTire(),
            new HankookTire(),
            new HankookTire(),
            new HankookTire()
    };

    void run() {
        for (Tire t : tires) {
            t.roll();
        }
    }

}
