package this_is_java.interface_exam.nested_class_interface;

public class A {
    class B {
        B() {}
        int instanceField;
        void instanceMethod() {
            System.out.println("A.B instanceMethod");
        }

        // 선언 되어있어도 에러는 나지 않지만
        // 호출 할 수 없으며 SafeDelete 처리 요청 들어옴
        static int staticField;
        static void staticMethod() {
            System.out.println("A.B staticMethod");
        }

        void method() {
            class D { // method 내에서만 사용하는 객체. 외부에서 접근 할 수 없다.
                D() {
                    System.out.println("A.B local class D Constructor");
                }
                int localClassInstanceField;
                void localClassInstanceMethod() {
                    System.out.println("A.B local class D instance method");
                }

                // 선언 되어있어도 에러는 나지 않지만
                // 호출 할 수 없으며 SafeDelete 처리 요청 들어옴
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
        class D { // method 내에서만 사용하는 객체. 외부에서 접근 할 수 없다.
            D() {
                System.out.println("A local class D Constructor");
            }
            int localClassInstanceField;
            void localClassInstanceMethod() {
                System.out.println("A local class D instance method");
            }

            // 선언 되어있어도 에러는 나지 않지만
            // 호출 할 수 없으며 SafeDelete 처리 요청 들어옴
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
