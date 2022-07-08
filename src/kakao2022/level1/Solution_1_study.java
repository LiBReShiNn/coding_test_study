package kakao2022.level1;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

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
        String[] arr2 = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] arr3;
        arr3 = new String[]{"muzi", "frodo", "apeach", "neo"};

        Stream<String> stream = Arrays.stream(arr1);
        Stream<String> streamOfArrayPart1 = Arrays.stream(arr1, 1, arr1.length);
        Stream<String> streamOfArrayPart2 = Arrays.stream(arr1, 1, arr1.length - 1);
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
        // parallelStream 병렬처리 스트림
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
//        5개의 “gen” 이 들어간 스트림이 생성됩니다. 초기화?

//        iterate 메소드를 이용하면 초기값과 해당 값을 다루는 람다를 이용해서 스트림에 들어갈 요소를 만듭니다.
//        다음 예제에서는 30이 초기값이고 값이 2씩 증가하는 값들이 들어가게 됩니다.
//        즉 요소가 다음 요소의 인풋으로 들어갑니다.
//        이 방법도 스트림의 사이즈가 무한하기 때문에 특정 사이즈로 제한해야 합니다.

        // 요소가 다음 요소의 인풋으로 들어간다.
        Stream<Integer> iteratedStream = Stream.iterate(0, n -> n + 2).limit(5); //[0, 2, 4, 6, 8]

//        기본 타입형 스트림
//        물론 제네릭을 사용하면 리스트나 배열을 이용해서 기본 타입(int, long, double) 스트림을 생성할 수 있습니다.
//        하지만 제네릭을 사용하지 않고 직접적으로 해당 타입의 스트림을 다룰 수도 있습니다.
//        range 와 rangeClosed 는 범위의 차이입니다.
//        두 번째 인자인 종료지점이 포함되느냐 안되느냐의 차이입니다.

//        제네릭을 사용하지 않기 때문에 불필요한 오토박싱(auto-boxing)이 일어나지 않습니다.
        IntStream intStream = IntStream.range(1, 5); // [1,2,3,4]
        LongStream longStream = LongStream.rangeClosed(1, 5); //[1,2,3,4,5]

//        에러. 박싱하지 않은 값은 Collection 이 아니기에 취급 불가.
//        System.out.println(intStream.collect(Collectors.toList()));

//        필요한 경우 boxed 메소드를 이용해서 박싱(boxing)할 수 있습니다.
        Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
//        정상
//        System.out.println(boxedIntStream.collect(Collectors.toList()));

//        Java 8 의 Random 클래스는 난수를 가지고
//        세 가지 타입의 스트림(IntStream, LongStream, DoubleStream)을 만들어낼 수 있습니다.
//        쉽게 난수 스트림을 생성해서 여러가지 후속 작업을 취할 수 있어 유용합니다.

//        로또생성 한줄컷
        IntStream randomInts = new Random().ints(6, 1, 46);
        System.out.println(randomInts.boxed().collect(Collectors.toList()));
        LongStream randomLongs = new Random().longs(5);
        DoubleStream randomDoubles = new Random().doubles(3);

//        문자열 스트링
//        스트링을 이용해서 스트림을 생성할수도 있습니다.
//        다음은 스트링의 각 문자(char)를 IntStream 으로 변환한 예제입니다.
//        char 는 문자이지만 본질적으로는 숫자이기 때문에 가능합니다.

//        문자를 숫자처럼 처리한다.
        IntStream charStream1 = " A AAAAAa 문자는 숫자임 ㅎ".chars().filter(s -> s == 65);
        System.out.println(charStream1.boxed().collect(Collectors.toList())); // [65, 65, 65, 65, 65, 65]
        IntStream charStream2 = " A AAAAAa 문자는 숫자임 ㅎ".chars().filter(s -> s > 64).filter(s -> s < 100);
        System.out.println(charStream2.boxed().collect(Collectors.toList())); // [65, 65, 65, 65, 65, 65, 97]

//        다음은 정규표현식(RegEx)을 이용해서 문자열을 자르고, 각 요소들로 스트림을 만든 예제입니다.
        Stream<String> stringStream = Pattern.compile("a").splitAsStream("asdfhajhaghjaaafghkgkaaafghkfghkaafkgaaaa");
//        잘라낸 공백도 스트림에 포함된다. 마지막 공백은 포함되지 않는다.
        System.out.println(stringStream.collect(Collectors.toList())); //[, sdfh, jh, ghj, , , fghkgk, , , fghkfghk, , fkg]

//        파일 스트림
//        자바 NIO 의 Files 클래스의 lines 메소드는 해당 파일의 각 라인을 스트링 타입의 스트림으로 만들어줍니다.
//        Charset.forName("UTF-8") -> StandardCharsets.UTF_8

        try (Stream<String> lineStream = Files.lines(Paths.get("file.txt"), StandardCharsets.UTF_8)) {
            System.out.println(lineStream.collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("no files"); // main에 넘어간 Exception은 반드시 처리.
        }

//        병렬 스트림 Parallel Stream. ...Fork/Join framework
//        스트림 생성 시 사용하는 stream 대신 parallelStream 메소드를 사용해서 병렬 스트림을 쉽게 생성할 수 있습니다.
//        내부적으로는 쓰레드를 처리하기 위해 자바 7부터 도입된 Fork/Join framework 를 사용합니다.

        List<Product> productList = new LinkedList<>();
        productList.add(new Product(1, "hi"));
        productList.add(new Product(2, "there"));
        productList.add(new Product(3, "fine"));

//        병렬 스트림 생성
        Stream<Product> parallelStream2 = productList.parallelStream();
//        병렬 여부 확인
        boolean isParallel = parallelStream2.isParallel();

//        따라서 다음 코드는 각 작업을 쓰레드를 이용해 병렬 처리됩니다.
        boolean isFirst = parallelStream2.map(product -> product.getPno()).anyMatch(pno -> pno > 2);

//        다음은 배열을 이용해서 병렬 스트림을 생성하는 경우입니다.
        Stream<String> arrParallelStream = Arrays.stream(arr1).parallel();

//        컬렉션과 배열이 아닌 경우는 다음과 같이 parallel 메소드를 이용해서 처리합니다.
        IntStream intStream1 = IntStream.builder().add(1).add(3).add(7).build().parallel();
        IntStream intStream2 = IntStream.range(1, 50).parallel();

//        다시 시퀀셜(sequential) 모드로 돌리고 싶다면 다음처럼 sequential 메소드를 사용합니다.
//        뒤에서 한번 더 다루겠지만 반드시 병렬 스트림이 좋은 것은 아닙니다.
        IntStream intStream3 = intStream1.sequential(); // default는 순차 수행
        isParallel = intStream3.isParallel(); // false

//        스트림 연결하기
//        Stream.concat 메소드를 이용해 두 개의 스트림을 연결해서 새로운 스트림을 만들어낼 수 있습니다.
        Stream<String> stream2 = Stream.of("muzi", "frodo", "neo", "apeach");
        Stream<String> stream3 = Stream.of("hi", "iam", "fine", "thank you", "and you");
        Stream<String> concatStream = Stream.concat(stream2, stream3);

//        가공하기
//        전체 요소 중에서 다음과 같은 API 를 이용해서 내가 원하는 것만 뽑아낼 수 있습니다.
//        이러한 가공 단계를 중간 작업(intermediate operations)이라고 하는데,
//        이러한 작업은 스트림을 리턴하기 때문에 여러 작업을 이어 붙여서(chaining) 작성할 수 있습니다.

        List<String> names = Arrays.asList(arr1);

//        Filtering
//        필터(filter)은 스트림 내 요소들을 하나씩 평가해서 걸러내는 작업입니다.
//        인자로 받는 Predicate 는 boolean 을 리턴하는 함수형 인터페이스로 평가식이 들어가게 됩니다.
//        Stream<T> filter(Predicate<? super T> predicate);

//        간단한 예제입니다.

        Stream<String> stream4 = names.stream().filter(name -> name.contains("a")); // [apeach]
//        스트림의 각 요소에 대해서 평가식을 실행하게 되고 ‘a’ 가 들어간 이름만 들어간 스트림이 리턴됩니다.

//        Mapping
//        맵(map)은 스트림 내 요소들을 하나씩 특정 값으로 변환해줍니다. 이 때 값을 변환하기 위한 람다를 인자로 받습니다.
//        <R> Stream<R> map(Function<? super T, ? extends R> mapper);
//        스트림에 들어가 있는 값이 input 이 되어서 특정 로직을 거친 후 output 이 되어 (리턴되는) 새로운 스트림에 담기게 됩니다.
//        이러한 작업을 맵핑(mapping)이라고 합니다.
//        간단한 예제입니다. 스트림 내 String 의 toUpperCase 메소드를 실행해서 대문자로 변환한 값들이 담긴 스트림을 리턴합니다.

        Stream<String> stream5 = names.stream().map(String::toUpperCase);

//        다음처럼 요소 내 들어있는 Product 개체의 수량을 꺼내올 수도 있습니다. 각 ‘상품’을 ‘상품의 수량’으로 맵핑하는거죠.

        Stream<Integer> stream6 = productList.stream().map(Product::getPno); // fuction, predicate

//        map 이외에도 조금 더 복잡한 flatMap 메소드도 있습니다.
//        <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
//        인자로 mapper를 받고 있는데, 리턴 타입이 Stream 입니다.
//        즉, [새로운 스트림을 생성해서 리턴하는 람다를 넘겨야]합니다.
//        flatMap 은 중첩 구조를 한 단계 제거하고 단일 컬렉션으로 만들어주는 역할을 합니다.
//        이러한 작업을 플래트닝(flattening)이라고 합니다.

//        다음과 같은 중첩된 리스트가 있습니다.
        List<List<String>> list2 = Arrays.asList(Arrays.asList("a"), Arrays.asList("b")); // [[a], [b]]
//        이를 flatMap을 사용해서 중첩 구조를 제거한 후 작업할 수 있습니다.
        List<String> flatList = list2.stream().flatMap(Collection::stream).collect(Collectors.toList()); // [a, b]

//        이번엔 객체에 적용해보겠습니다.
//        예제에서는 학생
//        1. 객체를 가진 스트림에서
//        2. 학생의 국영수 점수를 뽑아 ### .map(m -> Stream.<Object>of(m.getValues)) !!!! map으로 다시 스트림을 만든다.
//        3. 새로운 스트림을 만들어    ### 생성자. Stream.<T>of. Int/Long/DoubleStream.of(iterators...)
//        평균을 구하는 코드입니다. 이는 map 메소드 자체만으로는 한번에 할 수 없는 기능입니다.
//        ifPresent
        List<Student> students = new ArrayList<>();
        students.stream().flatMapToInt(student -> IntStream.of(student.getKor(), student.getEng(), student.getMath()))
                .average().ifPresent(avg -> System.out.println(Math.round(avg * 10) / 10.0));

//        Sorting
//        정렬의 방법은 다른 정렬과 마찬가지로 Comparator 를 이용합니다.
//        Stream<T> sorted ();
//        Stream<T> sorted(Comparator<? super T > comprator);
//        인자 없이 그냥 호출할 경우 오름차순으로 정렬합니다.

//        IntStream은 boxing 해야 읽을 수 있다.
        IntStream.of(95, 35, 6, 4, 36, 48, 3).sorted().boxed().collect(Collectors.toList()); // [3, 4, 6, 35, 36, 48, 95]

//        인자를 넘기는 경우와 비교해보겠습니다.
//        스트링 리스트에서 알파벳 순으로 정렬한 코드와 Comparator 를 넘겨서 역순으로 정렬한 코드입니다.
        List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
//        sorted(Collections)의 형태를 갖는다.
        lang.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());// [Swift, Scala, Python, Java, Groovy, Go]

//        Comparator 의 compare 메소드는 두 인자를 비교해서 값을 리턴합니다.
//        int compare(T o1, T o2);

//        기본적으로 Comparator 사용법과 동일합니다. 이를 이용해서 문자열 길이를 기준으로 정렬해보겠습니다.
        lang.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());// [Go, Java, Scala, Swift, Groovy, Python]

        lang.stream().sorted((s1, s2) -> s2.length() - s1.length()).collect(Collectors.toList());// [Groovy, Python, Scala, Swift, Java, Go]



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

class Product {
    int pno;
    String pname;
    public Product(int pno, String pname) {
        this.pno = pno; // setter 작업을 생성자로 처리
        this.pname = pname;
    }
    int getPno() {
        return pno;
    }

}

class Student {
    int kor;
    int eng;
    int math;

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }
}
