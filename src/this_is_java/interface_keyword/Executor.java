package this_is_java.interface_keyword;

public class Executor {

    public static void main(String[] args) {
        System.out.println(A.field);
        System.out.println(InterfaceName.methodStatic("하이"));
        A a = new A();
        System.out.println(a.methodAbstract("하이염"));
        System.out.println(a.methodDefault(2));

    }

    static class A implements InterfaceName {

        @Override
        public int methodAbstract(String value) {
            return value.length();
        }

//        @Override
//        public String methodDefault(int value) {
//            String str = InterfaceName.super.methodDefault(value);
//            return str + " 구현체";
//        }
    }
}
