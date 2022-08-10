package this_is_java.interface_exam.nested_class_interface;

public class Executor {
    public static void main(String[] args) {
//        A.B a = new A.B(); // error
        A a = new A();
        A.B b = a.new B();
        A.B ab = new A().new B();
        ab.instanceField = 5;
        ab.instanceMethod();

        // static �޼ҵ� ���� ȣ��
        C.B.staticField = 5;
        C.B.staticMethod();

        // ��ü ���� �� �� ���� ȣ��
        C.B cb = new C.B();
        cb.instanceField = 5;
        cb.instanceMethod();
//        cb.staticField = 5; // clean up code
//        cb.staticMethod();

        a.method();
        ab.method();
        C c = new C();
        c.method();
        cb.method();
    }

}
