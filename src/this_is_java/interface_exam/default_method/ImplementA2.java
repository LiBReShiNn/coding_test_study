package this_is_java.interface_exam.default_method;

public class ImplementA2 implements InterfaceA{
    
    @Override
    public void implementForcely() {
        System.out.println("ImplementA2 implementForcely");
    }

    
    @Override
    public void getDefaultMethod() {
        System.out.println("ImplementA2 getDefaultMethod");
    }
}
