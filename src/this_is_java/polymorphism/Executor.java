package this_is_java.polymorphism;

public class Executor {
    public static void main(String[] args) {
        Car car = new Car();

        for (int i = 0; i < 15; i++) {
            int problemLocation = car.run();
            if (problemLocation != 0) {
                if (problemLocation % 2 == 0) {
                    System.out.println(car.tires[problemLocation - 1].location + "Hankook for new one");
                    car.tires[problemLocation - 1] = new HankookTire(15, car.tires[problemLocation - 1].location);
                } else {
                    System.out.println(car.tires[problemLocation - 1].location + "Kumho for new one");
                    car.tires[problemLocation - 1] = new KumhoTire(12, car.tires[problemLocation - 1].location);
                }
            }
            System.out.println("----------------------------");
        }

//        for (int i = 0; i < 15; i++) {
//
//            int problemLocation = car.run();
//
//            switch (problemLocation) {
//                case 0 -> {
//                    continue;
//                }
//                case 1 -> {
//                    System.out.println("frontRightTire change to HankookTire");
//                    car.frontRightTire = new HankookTire(15, "frontRightTire");
//                }
//                case 2 -> {
//                    System.out.println("frontLeftTire change to KumhoTire");
//                    car.frontLeftTire = new KumhoTire(12, "frontLeftTire");
//                }
//                case 3 -> {
//                    System.out.println("backRightTire change to HankookTire");
//                    car.backRightTire = new HankookTire(16, "backRightTire");
//                }
//                case 4 -> {
//                    System.out.println("backLeftTire change to KumhoTire");
//                    car.backLeftTire = new KumhoTire(13, "backLeftTire");
//                }
//                default -> {
//                    System.out.println("ERROR");
//                    return;
//                }
//            }
//            System.out.println("------------------------------------------------");
//            problemLocation = 0;
//        }
    }
}
