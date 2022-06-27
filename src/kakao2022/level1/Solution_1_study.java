package kakao2022.level1;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution_1_study {

    private final Logger logger = LoggerFactory.getLogger(Solution_1_study.class);

    public int[] solution(String[] id_list, String[] report, int k) {

        /*
         스트림 Streams
         자바 8에서 추가한 스트림(Streams)은 람다를 활용할 수 있는 기술 중 하나입니다.
         자바 8 이전에는 배열 또는 컬렉션 인스턴스를 다루는 방법은 for 또는 foreach 문을 돌면서 요소 하나씩을 꺼내서 다루는 방법이었습니다.
         간단한 경우라면 상관없지만 로직이 복잡해질수록 코드의 양이 많아져 여러 로직이 섞이게 되고, 메소드를 나눌 경우 루프를 여러 번 도는 경우가 발생합니다.

         스트림은 '데이터의 흐름’입니다.
         배열 또는 컬렉션 인스턴스에 함수 여러 개를 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있습니다.
         또한 람다를 이용해서 코드의 양을 줄이고 간결하게 표현할 수 있습니다.
         즉, 배열과 컬렉션을 함수형으로 처리할 수 있습니다.

         또 하나의 장점은 간단하게 병렬처리(multi-threading)가 가능하다는 점입니다.
         하나의 작업을 둘 이상의 작업으로 잘게 나눠서 동시에 진행하는 것을 병렬 처리(parallel processing)라고 합니다.
         즉 쓰레드를 이용해 많은 요소들을 빠르게 처리할 수 있습니다.

         스트림에 대한 내용은 크게 세 가지로 나눌 수 있습니다.

         생성하기 : 스트림 인스턴스 생성.
         가공하기 : 필터링(filtering) 및 맵핑(mapping) 등 원하는 결과를 만들어가는 중간 작업(intermediate operations).
         결과 만들기 : 최종적으로 결과를 만들어내는 작업(terminal operations).

         전체 -> 맵핑 -> 필터링 1 -> 필터링 2 -> 결과 만들기 -> 결과물

         */

//        생성하기
//        보통 배열과 컬렉션을 이용해서 스트림을 만들지만 이 외에도 다양한 방법으로 스트림을 만들 수 있습니다. 하나씩 살펴보겠습니다.
//
//        배열 스트림
//        스트림을 이용하기 위해서는 먼저 생성을 해야 합니다.
//        스트림은 배열 또는 컬렉션 인스턴스를 이용해서 생성할 수 있습니다.
//        배열은 다음과 같이 Arrays.stream 메소드를 사용합니다.

        // 초기 대입
        String[] arr1 = {"muzi", "frodo", "apeach", "neo"};
        // 객체 생성 후 초기화
        String[] arr2 = new String[] {"muzi", "frodo", "apeach", "neo"};
        String[] arr3;
        arr3 = new String[]{"muzi", "frodo", "apeach", "neo"};

        Stream<String> stream = Arrays.stream(arr1);
        Stream<String> streamOfArrayPart1 = Arrays.stream(arr1,1,arr1.length);
        Stream<String> streamOfArrayPart2 = Arrays.stream(arr1,1,arr1.length-1);
        List<String> Lstream = Arrays.stream(arr1).collect(Collectors.toList());
        List<String> LstreamOfArrayPart1 = Arrays.stream(arr1, 1, arr1.length).collect(Collectors.toList());
        List<String> LstreamOfArrayPart2 = Arrays.stream(arr1, 1, arr1.length - 1).collect(Collectors.toList());

//        컬렉션 스트림
//        컬렉션 타입(Collection, List, Set)의 경우 인터페이스에 추가된 디폴트 메소드 stream 을 이용해서 스트림을 만들 수 있습니다.
//        public interface Collection<E> extends Iterable<E> {
//            default Stream<E> stream() {
//                return StreamSupport.stream(spliterator(), false);
//            }
//            // ...
//        }

        // asList
        List<String> list1 = Arrays.asList(arr1);
        // stream
        Stream<String> stream1 = list1.stream();
        // parallelStream
        Stream<String> parallelStream = list1.parallelStream();

//        비어 있는 스트림
//        비어 있는 스트림(empty streams)도 생성할 수 있습니다. 언제 빈 스트림이 필요할까요?
//        빈 스트림은 요소가 없을 때 null 대신 사용할 수 있습니다.
//        public Stream<String> streamOf(List<String> list) {
//            return list == null || list.isEmpty()
//                    ? Stream.empty()
//                    : list.stream();
//        }
        Stream<String> emptyStream = list1 == null || list1.isEmpty() ? Stream.empty() : list1.stream();

//        Stream.builder()
//        빌더(Builder)를 사용하면 스트림에 직접적으로 원하는 값을 넣을 수 있습니다. 마지막에 build 메소드로 스트림을 리턴합니다.
//        제네릭 호출시 형지정 방식. <String>function(); 생성자. 빌더..

        Stream<String> builderStream = Stream.<String>builder().add("a").add("b").add("c").build();

//        Stream.generate() [특정 사이즈로 최대 크기를 제한해야 합니다]
//        generate 메소드를 이용하면 Supplier<T> 에 해당하는 람다로 값을 넣을 수 있습니다.
//        Supplier<T> 는 인자는 없고 리턴값만 있는 함수형 인터페이스죠. 람다에서 리턴하는 값이 들어갑니다.
//        public static<T> Stream<T> generate(Supplier<T> s) { ... }
//        이 때 생성되는 스트림은 크기가 정해져있지 않고 무한(infinite)하기 때문에 특정 사이즈로 최대 크기를 제한해야 합니다.

        Stream<String> generatedStream = Stream.generate(() -> "gen").limit(3);
        // 5개의 “gen” 이 들어간 스트림이 생성됩니다. 초기화?




















        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}
