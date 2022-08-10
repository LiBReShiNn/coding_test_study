package this_is_java.interface_exam.default_method;

public class Executor {
    public static void main(String[] args) {
        InterfaceA a = new ImplementA();
        a.getDefaultMethod();
        a.implementForcely();

        a = new ImplementA2();
        a.getDefaultMethod();
        a.implementForcely();

    }
}
