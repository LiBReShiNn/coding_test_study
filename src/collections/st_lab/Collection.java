//package collections.st_lab;
//
//import collections.T;
//import collections.st_lab.stack.Stack;
//
//import java.util.*;
//
//
///**
// * Iterable <- Collection <- List, Queue, Set(none linear)
// * Map은 컬렉션이 아니다.
// * <p>
// * Collection 또한 단순한 mapping과는 다르다.
// */
//public class Collection {
//
//    // List 선형
//    ArrayList<T> arrayList = new ArrayList<>(); // 임의접근
//    LinkedList<T> linkedList = new LinkedList<>(); // 추가 삭제 용이
//    Vector<T> vector = new Vector<>(); // ArrayList와 같지만 항상 동기화 상태 유지한다. 멀티스레스 환경에서 안전. 단일 스레드 에서도 동기화를 하기 때문에 비효율적
//    collections.st_lab.stack.Stack<T> stack = new collections.st_lab.stack.Stack<>(); // extends Vector. 동기화 & 후입선출.
//
//
//    // 방법 2
//    List<T> arraylist = new ArrayList<>();
//    List<T> linkedlist = new LinkedList<>();
//    List<T> vector = new Vector<>();
//    List<T> stack = new collections.st_lab.stack.Stack<>();
//
//    // Stack은 Vector를 상속하기 때문에 아래와 같이 생성할 수 있다.
//    Vector<T> stack = new Stack<>();
//
////    Method
////    add remove contains size get set isEmpty equals indexOf clear
////    boolean result = stack.remove(obj); // 지정한 객체와 같은 [첫번째 객체] 삭제
//
//
//
//    // Queue 선형 & 선입선출
//    // Dequeue tail에서도 입력 가능, 맨 위에 놓거나, 맨 아래 놓거나.
//    // PriorityQueue 데이터 우선순위에 기반하여 우선순위가 높은 데이터가 먼저. 낮은 숫자가 높은 우선순위를 갖는다. 최대, 최솟값 구할때 유용.
//    //                다만 사용자가 정의한 객체를 타입으로 사용하는 경우 반드시 Comparator 또는 Comparable을 통해서 정렬 방식을 구현해야한다
//
//    ArrayDeque<T> arrayDeque = new ArrayDeque<>();
//    PriorityQueue<T> priorityQueue = new PriorityQueue<>();
//
//    Queue<T> arrayDeque = new ArrayDeque<>();
//    Queue<T> linkedListQueue = new LinkedList<>();
//    Queue<T> priorityQueue = new PriorityQueue<>();
//
//    Deque<T> arrayDeque = new ArrayDeque<>();
//    Deque<T> linkedListDeque = new LinkedList<>();
//
//    //Queue/Deque method
//    // add 꼬리에 요소를 추가. 큐가 모두 차는 경우 illegalStateException 던짐
//    // offer 꼬리에 요소를 추가. 큐가 모두 차도 에러 던지지 않음
//    // peek 헤드를 삭제하지 않고 검색하여 요소를 반환한다. -> stream...
//    // poll 헤드 검색 및 삭제 하면서 요소를 반환한다.
//
//    // Deque Method
//    // addLast 요소를 꼬리에 추가 큐가 모두 차는 경우 illegalStateException 던짐
//    // addFirst 요소를 헤더에 추가 큐가 모두 차는 경우 illegalStateException 던짐
//    // offerLast 요소를 꼬리에 추가. 에러안던짐
//    // offerFirst 요소를 헤더에 추가. 에러안던짐
//    // peekLast 꼬리에 있는 요소를 삭제하지않고 반환
//    // peekFirst 헤더에 있는 요소를 삭제하지 않고 검색.
//    // pollLast 꼬리에 있는 요소를 삭제 후 반환
//    // pollFirst 헤더에 있는 요소를 삭제 후 반환
//    // size
//
//
//
//    // 비선형 Graph, Tree
//
//
//
//    // Set 집합. 선형, 비선형이 아님. 선으로 이어서 표현 할 수 없음.
//    // 데이터를 중복해서 저장하지 않는다. 입력 순서대로 저장하지 않는다.
//    // LinkedHashSet은 [저장 순서는 보장] 하지만 같은 데이터를 중복저장하지는 않는다.
//    // SortedSet 정렬 된 set (TreeSet)
//    // Set interface.
//
//    // HashSet, LinkedHashSet, TreeSet
//
//    // HashSet (성능 우수, 해시로 데이터의 위치를 특정한다.)
//    // 중복확인. hash를 사용하여 데이터의 위치를 특정시켜 해당 데이터를 빠르게 색인 하도록 만든것.
//    // Hash 기능과 Set의 기능이 합쳐진것.
//    // 삽입, 삭제, 색인이 매우 빠르다.
//
//    // LinkedHashSet
//    // 중복은 허용하지 않으면서 순서를 보장 받고 싶은 경우
//    // 실생활에서 그나마 예로 들자면 페이지를 열 때 만약 해당 페이지가 중복되경우 cache는 다시 적재할 필요는 없지만,
//    // 새로운 페이지를 할당해야 할 경우 최근에 사용되지 않은 cache을 비우고자 할 때,
//    // 가장 오래된 cache를 비우는 것이 현명할 것이다.
//    // 이를 LRU 알고리즘(Least Recently Used Algorithm)이라고 하는데,
//    // 이럴 때 입력된(저장된) 순서를 알아야 오래된 캐시를 비울 수 있다. 이에 적용할 수 있는 자료구조 중 하나다.
//    // (현실적으로는 LRU기법으로 LinkedHashMap이라는 자료구조가 대부분을 차지하고 있어 많이 쓰이진 않으나 그나마 이해하기 쉬운 예시를 위해..)
//
//    // TreeSet 저장 순서 보장 x, 중복 데이터 x, 데이터 값의 순서는 보장.
//    // 데이터의 가중치에 따른 순서대로 정렬되어 있다.
//    // Tree = 데이터를 일정 순서에 의해 정렬하는 구조
//
//    /*
//    T는 객체 타입을 의미하며 기본적으로
//    Integer, String, Double, Long 같은 Wrapper Class부터
//    사용자 정의 객체까지 가능하다.
//    단, primitive type은 불가능하다.
//    */
//
//    HashSet<T> hashSet = new HashSet<>();
//    LinkedHashSet<T> linkedHashSet = new LinkedHashSet<>();
//    TreeSet<T> treeSet = new TreeSet<>();
//
//    Set<T> hashSet = new HashSet<>();
//    Set<T> linkedHashSet = new LinkedHashSet<>();
//    Set<T> treeSet = new TreeSet<>();
//
//    SortedSet<T> treeSet = new TreeSet<>();
//
//
//}
