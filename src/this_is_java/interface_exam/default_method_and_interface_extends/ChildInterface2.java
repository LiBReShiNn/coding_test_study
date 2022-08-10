package this_is_java.interface_exam.default_method_and_interface_extends;

public interface ChildInterface2 extends ParentInterface{

    
    @Override
    default void implementForcelyParent() {
        System.out.println("ChildInterface2 Override implementForcelyParent");
    }

    
    @Override
    default void getDefaultMethodParent() {
        System.out.println("ChildInterface2 Override getDefaultMethodParent");
    }

    void implementForcelyChild();
    default void getDefaultMethodChild() {
        System.out.println("ChildInterface2 getDefaultMethodChild");
    }
}
