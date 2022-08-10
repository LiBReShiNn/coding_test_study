package this_is_java.interface_exam.default_method;

public interface InterfaceA {

    void implementForcely ();

    default void getDefaultMethod() {
        System.out.println("InterfaceA method");
    }
}
