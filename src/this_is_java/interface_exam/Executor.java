package this_is_java.interface_exam;

public class Executor {
    public static void main(String[] args) {
        InterfaceA a = new InterfaceA() {
            @Override
            public String getStr() {
                return "гоюл";
            }

            @Override
            public int getInteger() {
                return 1000;
            }
        };
        System.out.println(a.getInteger());
        System.out.println(a.getStr());
        a.getDefault();
    }
}
