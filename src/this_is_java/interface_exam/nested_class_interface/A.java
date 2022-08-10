package this_is_java.interface_exam.nested_class_interface;

public class A {
    class B {
        B() {}
        int instanceField;
        void instanceMethod() {
            System.out.println("A.B instanceMethod");
        }

        // ���� �Ǿ��־ ������ ���� ������
        // ȣ�� �� �� ������ SafeDelete ó�� ��û ����
        static int staticField;
        static void staticMethod() {
            System.out.println("A.B staticMethod");
        }

        void method() {
            class D { // method �������� ����ϴ� ��ü. �ܺο��� ���� �� �� ����.
                D() {
                    System.out.println("A.B local class D Constructor");
                }
                int localClassInstanceField;
                void localClassInstanceMethod() {
                    System.out.println("A.B local class D instance method");
                }

                // ���� �Ǿ��־ ������ ���� ������
                // ȣ�� �� �� ������ SafeDelete ó�� ��û ����
                static int localClassStaticField;
                static void localClassStaticMethod() {
                    System.out.println("A.B local class D instance method");
                }
            }

            D d = new D();
            d.localClassInstanceField = 5;
            System.out.println(d);
            d.localClassInstanceMethod();

        }
    }

    void method() {
        class D { // method �������� ����ϴ� ��ü. �ܺο��� ���� �� �� ����.
            D() {
                System.out.println("A local class D Constructor");
            }
            int localClassInstanceField;
            void localClassInstanceMethod() {
                System.out.println("A local class D instance method");
            }

            // ���� �Ǿ��־ ������ ���� ������
            // ȣ�� �� �� ������ SafeDelete ó�� ��û ����
            static int localClassStaticField;
            static void localClassStaticMethod() {
                System.out.println("A local class D instance method");
            }
        }

        D d = new D();
        d.localClassInstanceField = 5;
        System.out.println(d);
        d.localClassInstanceMethod();

    }
}
