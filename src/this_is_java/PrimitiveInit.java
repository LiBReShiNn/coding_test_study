package this_is_java;

public class PrimitiveInit {

    public static void main(String[] args) {

//        String a = ''; // char is not String
        String b = "";
//        char c = ''; // error
//        int d = null; // error primitive는 객체가 아니다. null 불가

//        float e = 3.14; // error

        // 정수타입
        byte h = 1; // 1byte
        short i = 1; // 2byte
        char l = 'a'; // 2bype
        int j = 1; // 4byte
        long k = 1; // 8byte

        // 실수 타입
        float f = 3.14f; // 4byte
        double g = 3.14; // 8 byte

//        연산을 실행하면 자동으로 타입 변환이 일어난다.
//        primitive는 type이라는 표현을 많이 쓰는듯? wapper class는 형 이라는 표현을 쓰는 느낌..

        // 자동 타입 변환 Promotion
        // 작은 크기를 갖는 타입이 큰 크기를 가지는 타입에 저장될 때.
        // 타입의 구분은 사용하는 메모리의 크기
//        int = byte

        // 강제 타입 변환
//        byte = (byte) shot

        // 자바는 정수연산일 경우 int 타입을 기본으로 한다. 4type보다 작은 byte short char 는 4byte인 int로 먼저 변환 된 후 연산이 수행된다.
        char m = 'A';
        int n = m + 1;
        char o = (char) n; // 'B'

        // 연산자 우선순위

                byte b1 = 1;
                byte b2 = 2;

//                ByteProcess plus1 = (x, y) -> {return x + y;};
                ByteProcess plus1 = Integer::sum;
                int r = plus1.bytePlus(b1, b2);

        System.out.println(r);

    }
    @FunctionalInterface
    interface ByteProcess {
        int bytePlus(byte x, byte y);
    }

}
