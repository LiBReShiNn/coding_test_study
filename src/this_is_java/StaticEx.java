package this_is_java;

public class StaticEx {

    static int a = 1;
    static int b = 2;
    static int sum;
    double div;

    static {
        sum = a + b;
    }

    static double divide() {
        StaticEx e = new StaticEx();
        e.div = (double) sum / b;
        // int / int = int. 올바른 계산을 위해서는 항상 업캐스팅 진행 후 계산.
        return e.div;
    }

    public static void main(String[] args) {
        System.out.println(StaticEx.sum);
        System.out.println(StaticEx.divide());
    }

}
