package this_is_java.interface_exam.default_method_and_interface_extends;

public interface ChildInterface1 extends ParentInterface{

    void implementForcelyChild();

    default void getDefaultMethodChild() {
        System.out.println("ChildInterface1 getDefaultMethodChild");
    }
}
