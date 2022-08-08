package this_is_java.interface_exam;

public interface InterfaceA {

    String getStr();
    int getInteger();
    default void getDefault(){
        System.out.println("구현체에 선언 되지 않은 default 호출");
    }
}
