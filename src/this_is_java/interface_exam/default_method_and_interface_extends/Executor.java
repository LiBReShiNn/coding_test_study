package this_is_java.interface_exam.default_method_and_interface_extends;

public class Executor {
    public static void main(String[] args) {

        ChildInterface1 c = new ChildInterface1() {
            @Override
            public void implementForcelyChild() {
                System.out.println("NoNameClass implementForcelyChild");
            }

            @Override
            public void implementForcelyParent() {
                System.out.println("NoNameClass implementForcelyParent");
            }
        };

        c.getDefaultMethodChild(); //ChildInterface1 getDefaultMethodChild
        c.implementForcelyChild(); //NoNameClass implementForcelyChild
        c.getDefaultMethodParent(); //ParentInterface getDefaultMethodParent
        c.implementForcelyParent(); //NoNameClass implementForcelyParent

        ChildInterface2 c2 = () -> System.out.println("NoNameClass implementForcelyChild");

        c2.getDefaultMethodChild(); //ChildInterface2 getDefaultMethodChild
        c2.implementForcelyChild(); //NoNameClass implementForcelyChild
        c2.getDefaultMethodParent(); //ChildInterface2 Override getDefaultMethodParent
        c2.implementForcelyParent(); //ChildInterface2 Override implementForcelyParent

    }
}
