package this_is_java.interface_keyword;

public interface InterfaceName {
    // 상수
    double field = 3.14;
    // 추상 메소드 public abstract 컴파일시 키워드 붙임
    int methodAbstract(String value); // 추상메서드는 body가 없다. -> 구현체에서 무조건 구현
    // 디폴트 메소드
    default String methodDefault(int value) {
        return value + "하이";
    }
    // 정적 메소드
    static boolean methodStatic(String value) {
        return value.equals("하이");
    }
}
