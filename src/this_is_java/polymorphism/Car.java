package this_is_java.polymorphism;

public class Car {

    // 런타임 시 대입된 필드 값의 변화를 통해 다형성을 구현한다.
    Tire frontRightTire = new Tire(5, "frontRightTire");
    Tire frontLeftTire = new Tire(4, "frontLeftTire");
    Tire backRightTire = new Tire(6, "backRightTire");
    Tire backLeftTire = new Tire(3, "backLeftTire");

    int run() {
        System.out.println("car runs");
        if (!frontRightTire.roll()) {stop(); return 1;}
        if (!frontLeftTire.roll()) {stop(); return 2;}
        if (!backRightTire.roll()) {stop(); return 3;}
        if (!backLeftTire.roll()) {stop(); return 4;}
        return 0;
    }

    void stop() {
        System.out.println("car stops");
    }

}
