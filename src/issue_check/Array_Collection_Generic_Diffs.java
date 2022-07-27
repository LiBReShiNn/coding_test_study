package issue_check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_Collection_Generic_Diffs {

    public static void main(String[] args) {

        // 배열
        // 업캐스팅은 실질적으로 그 데이터의 타입을 바꾸는 것이 아니다.
        // 컴파일 타임에는 문제 없이 넘어가지만 런타임에 데이터 타입의 불일치가 일어나면 에러가 발생하게 된다.
        Integer[] ia = new Integer[10];
        Number[] na = ia;
//        na[0] = 1.4; // java.lang.ArrayStoreException

        System.out.println(Arrays.stream(na).toArray());

        // Collection은 컴파일 시간에 제네릭 타입을 통해 타입을 체크하여 런타임 오류를 사전에 방지한다.
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
//        List<Number> numbers = integers; // 인텔리제이에서 작성과 동시에 에러임을 알리고 Migrate 선택지 띄움

        Integer[] myInts = {1,2,3,4,5};
        Long[] myLongs = {1L, 2L, 3L, 4L, 5L};
        Double[] myDoubles = {1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println(sum(myInts));// 정상 응답.
        System.out.println(sum(myLongs));// 정상 응답.
        System.out.println(sum(myDoubles));// 정상 응답.

        List<Integer> myIntsG = Arrays.asList(1,2,3,4,5);
        List<Long> myLongsG = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<Double> myDoublesG = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
//        System.out.println(sumG(myIntsG)); // 컴파일 에러
//        System.out.println(sumG(myLongsG)); // 컴파일 에러
//        System.out.println(sumG(myDoublesG)); // 컴파일 에러

    }

    public static Number sum(Number[] numbers) {
        long sum = 0;
        for (Number number : numbers) {
            sum += number.longValue();
        }
        return sum;
    }

    public static Number sumG(List<Number> numbers) {
        long sum = 0;
        for (Number number : numbers) {
            sum += number.longValue();
        }
        return sum;
    }
}
