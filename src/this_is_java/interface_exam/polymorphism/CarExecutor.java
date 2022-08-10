package this_is_java.interface_exam.polymorphism;

public class CarExecutor {
    public static void main(String[] args) {
        Car c = new Car();

        c.run();

//        c.backLeft = new KumhoTire();
//        c.frontLeft = new KumhoTire();
        c.tires[0] = new KumhoTire();
        c.tires[2] = new KumhoTire();

        c.run();
    }
}
