package this_is_java.polymorphism;

public class Executor {
    public static void main(String[] args) {
        Car car = new Car();

        for (int i = 0; i < 15; i++) {

            int problemLocation = car.run();

            switch (problemLocation) {
                case 0 -> {
                    continue;
                }
                case 1 -> {
                    System.out.println("frontRightTire change to HankookTire");
                    car.frontRightTire = new HankookTire(15, "frontRightTire");
                }
                case 2 -> {
                    System.out.println("frontLeftTire change to KumhoTire");
                    car.frontLeftTire = new KumhoTire(12, "frontLeftTire");
                }
                case 3 -> {
                    System.out.println("backRightTire change to HankookTire");
                    car.backRightTire = new HankookTire(16, "backRightTire");
                }
                case 4 -> {
                    System.out.println("backLeftTire change to KumhoTire");
                    car.backLeftTire = new KumhoTire(13, "backLeftTire");
                }
                default -> {
                    System.out.println("ERROR");
                    return;
                }
            }
            System.out.println("------------------------------------------------");
            problemLocation = 0;
        }
    }
}
