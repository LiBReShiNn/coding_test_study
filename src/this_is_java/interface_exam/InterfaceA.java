package this_is_java.interface_exam;

public interface InterfaceA {

    String getStr();
    int getInteger();
    default void getDefault(){
        System.out.println("����ü�� ���� ���� ���� default ȣ��");
    }
}
