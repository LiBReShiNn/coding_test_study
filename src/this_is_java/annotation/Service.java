package this_is_java.annotation;

public class Service {

    @PrintAnnotaion
    public void method1() {
        System.out.println("content1");
    }

    @PrintAnnotaion("*")
    public void method2() {
        System.out.println("content2");
    }

    @PrintAnnotaion(value = "*", number = 30)
    public void method3() {
        System.out.println("content3");
    }
}
