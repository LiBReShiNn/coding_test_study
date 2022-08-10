package this_is_java.interface_exam.nested_class_interface;

public class C {
    static class B {
        B() {}
        int instanceField;
        void instanceMethod() {
            System.out.println("B instanceMethod");
        }
        static int staticField;
        static void staticMethod() {
            System.out.println("B staticMethod");
        }

        void method() {
            class D {
                D() {
                    System.out.println("C.B local class D Constructor");
                }
                int localClassInstanceField;
                void localClassInstanceMethod() {
                    System.out.println("C.B local class D instance method");
                }

                // ���� �Ǿ��־ ������ ���� ������
                // ȣ�� �� �� ������ SafeDelete ó�� ��û ����
                static int localClassStaticField;
                static void localClassStaticMethod() {
                    System.out.println("C.B local class D instance method");
                }
            }

            D d = new D();
            d.localClassInstanceField = 5;
            System.out.println(d);
            d.localClassInstanceMethod();
        }

    }

    void method() {
        class D {
            D() {
                System.out.println("C local class D Constructor");
            }
            int localClassInstanceField;
            void localClassInstanceMethod() {
                System.out.println("C local class D instance method");
            }

            // ���� �Ǿ��־ ������ ���� ������
            // ȣ�� �� �� ������ SafeDelete ó�� ��û ����
            static int localClassStaticField;
            static void localClassStaticMethod() {
                System.out.println("C local class D instance method");
            }
        }

        D d = new D();
        d.localClassInstanceField = 5;
        System.out.println(d);
        d.localClassInstanceMethod();
    }


}
