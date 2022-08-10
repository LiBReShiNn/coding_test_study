package this_is_java.interface_exam.default_method_and_interface_extends;

public interface ParentInterface {

    void implementForcelyParent ();

    default void getDefaultMethodParent() {
        System.out.println("ParentInterface getDefaultMethodParent");
    }
}
