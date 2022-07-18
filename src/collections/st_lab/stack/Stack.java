package collections.st_lab.stack;

import collections.T;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E>, Cloneable {

    // 용적과 사이즈는 다르다. 용적은 담을 수 있는 크기, size는 가지고 있는 요소의 갯수이다.
    private static final int DEFAULT_CAPACITY = com.sun.xml.internal.fastinfoset.util.ValueArray.DEFAULT_CAPACITY; // 10;
    // 공간할당이 0
    private static final Object[] EMPTY_ARRAY = jdk.nashorn.internal.runtime.ScriptRuntime.EMPTY_ARRAY; // new Object[0];

    private Object[] array;
    private int size;

    // 초기 공간 할당 x
    public Stack() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    // 초기 공간 할당 o
    public Stack(int capacity) {
        this.array = new Object[capacity];
        this.size = 0; // 배열에 담긴 요소의 개수. 용적의 크기와 무관하다.
    }

    Stack<Integer> stack = new Stack<>();
    // 한 번쯤 코딩하다보면 'java.lang.StackOverflowError' 를 경험할텐데 보통은 재귀가 깊어지면서 발생할 것이다.
    // 이는 메소드를 호출 할 때마다 메소드 내에 정의 된 변수들의 값이 stack 메모리에 쌓이게 되는데
    // 재귀가 깊어지면 stack 메모리에 이 값들이 쌓이면서 해당 총량이 할당 된 메모리 양보다 커질 때 내뱉게 된다.


    // 참고로 자바 내부에서는 스택은 Vector 클래스를 상속받아 사용한다.
    // Vector 자료구조는 ArrayList와 크게 다르지 않다.
    // 내부 구조는 Object[] 배열로 데이터들을 관리하며 전체적인 메소드 구조 또한 많이 유사하다.
    // 다만 차이점은 동기화를 지원하냐 안하냐의 여부인데, ArrayList에서는 동기화를 지원하지 않고, Vector에서는 동기화를 지원한다.
    // 그렇다보니 속도 자체는 ArrayList가 조금 더 빠르지만, Thread safe 하지 않다.
    // 쉽게 생각해서 멀티스레드 환경에서는 Vector를, 아닐경우 ArrayList를 쓰는 것이 현명하다.


    // [Stack의 활용] 상단으로 부터의 거리.
    // 1. 페이지 뒤로가기
    // 2. 실행 취소
    // 3. 수식 괄호 검사 ( 여는 괄호가 있으면 반드시 닫는 괄호가 있어야한다. )

//    Stack Method
//    push(e) 스택의 맨 위에 요소를 추가
//    pop(e) 스택의 맨 위 요소를 제거하면서 값을 반환
//    peek(e) 스택의 맨위 값 제거하지 않고 반환
//    search(obj) 스택의 [상단부터] 검색. [거리개념]. 지정된 객체가 있는 요소의 위치를 반환. top의 위치부터 내려가면서 탐색한다. 요소가 없는 경우 -1
//    clear() 모든 요소 제거
//    empty() 현재 스택에 요소가 [없는] 경우 true, 그외 false

    // 모든 것은 동적 할당으로서 구현한다.
    // resize 구현
    // size 가 capacity에 얼만큼 차있는지 확인 후 적절한 크기로 변경.

    private void resize() {

        // 빈 배열
        if (Arrays.equals(array, EMPTY_ARRAY)) { // equals를 사용하지 않으면 주소를 비교하므로 주의. 두 배열의 값들이 같니? Arrays.equals(a,b)
            array = new Object[DEFAULT_CAPACITY]; // 10
            return;
        }

        int arrayCapacity = array.length; // length는 size개념이 아닌 capacity.

        // 늘려준다.
        if (size == arrayCapacity) {
            int newSize = arrayCapacity * 2;

            array = Arrays.copyOf(array, newSize); // origin, new size . 나머지 공간은 null(E)로 채워진다.
            return;
        }

        // 불필요한 공간을 줄인다.
        if (size < (arrayCapacity / 2)) {
            int newCapacity = (arrayCapacity / 2);

            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
            return;
        }

    }


    /**
     * 스택의 맨 위에 요소를 추가합니다.
     *
     * @param item 스택에 추가할 요소
     * @return 스택에 추가된 요소
     */
    @Override
    public E push(E item) {

        if (size == array.length) {
            resize();
        }
        array[size] = item; // size 는 현재의 요소 크기.
        size++;

        return item;
    }

    /**
     * 스택의 맨 위에 있는 요소를 제거하고 제거 된 요소를 반환합니다.
     *
     * @return 제거 된 요소
     */
    @Override
    public E pop() {

        if (size == 0) {
            throw new EmptyStackException();
        }

        // @SuppressWarnings("unchecked")을 붙이지 않으면 type safe(타입 안정성)에 대해 경고를 보낸다.
        // 반환되는 것을 보면 E 타입으로 캐스팅을 하고 있고 그 대상이 되는 것은 Object[] 배열의 Object 데이터다.
        // 즉, Object -> E 타입으로 변환을 하는 것인데 이 과정에서
        // 변환할 수 없는 타입을 가능성이 있다는 경고로 메소드 옆에 경고표시가 뜨는데,
        // 우리가 push하여 받아들이는 데이터 타입은 [유일하게 E 타입만 존재]한다.
        // 그렇기 때문에 [형 안정성이 보장된다.]
        // 한마디로 ClassCastException이 뜨지 않으니 이 경고들을 무시하겠다는 것이 @SuppressWarnings("unchecked") 이다.
        // 형 변환시 예외 가능성이 없을 확실한 경우에 최소한의 범위에서 써주는 것이 좋다.
        @SuppressWarnings("unchecked") // try to generify 제거
        E obj = (E) array[size - 1]; // 삭제될 요소를 반환하기 위한 임시변수

        array[size - 1] = null;
        size--;
        resize(); // 자료가 들어오고 나갈 때 마다 리사이징

        return obj;
    }

    /**
     * 스택의 맨 위에 있는 요소를 제거하지 않고 반환합니다.
     *
     * @return 스택의 맨 위에 있는 요소
     */
    @SuppressWarnings("unchecked") // "deprecation", "rawtypes", "unchecked", "serial"
    @Override
    public E peek() {

        if (size == 0) {
            throw new EmptyStackException();
        }

        return (E) array[size - 1];
    }

    /**
     * 스택의 상반 부터 특정 요소가 몇 번째 위치에 있는지를 반환합니다.
     * 중복되는 원소가 있을경우 가장 위에 있는 요소의 위치가 반환됩니다.
     *
     * @param value 스택에서 위치를 찾을 요소
     * @return 스택의 상단부터 처음으로 요소와 일치하는 위치를 반환.
     * 만약 일치하는 요소가 없을 경우 -1 을 반환
     */
    @Override
    public int search(Object value) {
        // Java API를 보면 search() 라는 메소드가 있다.
        // 이는 '찾으려는 데이터가 상단의 데이터로부터 얼마만큼 떨어져 있는지'에 대한 상대적 위치 값이다.
        // 쉽게 말하자면 Top으로부터 떨어져있는 거리를 의미한다. (단, 1부터 시작)
        // 수식으로 표현하자면 size - index 값이 되겠다.
        // 다만 일치하는 데이터를 찾지 못했을 경우는 -1 을 반환한다.

        for (int idx = size - 1; idx >= 0; idx--) {
            // 같은 객체를 찾으면 size - idx 값을 반환한다.
            // top으로 부터 가장 가까운 위치의 obj 반환.
            if (array[idx].equals(value)) {
                return size - idx; // top으로 부터의 거리.
            }
        }

        return -1;
    }

    /**
     * 스택의 요소 개수를 반환합니다.
     *
     * @return 스택에 있는 요소 개수를 반환
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 스택에 있는 모든 요소를 삭제합니다.
     */
    @Override
    public void clear() {
        // 모든 요소를 비워버린다는 것은 요소가 0개라는 말로 size 또한 0으로 초기화해주고,
        // 배열의 용적 또한 현재 용적의 절반으로 줄일 수 있도록 해준다.
        // 왜 초기 값이 아니라 절반이죠? 라고 질문할 수도 있다.
        // 물론 초기값으로 초기화 해주어도 되나 생각해보면 현재 배열의 용적은 결국 데이터를 해당 용적에 만족하는 조건만큼 썼다는 의미가 된다.
        // 예로들어 데이터가 1500개였다고 가정해보자. 그럼 용적량은 10부터 2씩 곱해지므로 2560이었을 것이다.
        // 요소들을 모두 초기화 했더라도 앞으로 들어올 데이터들 또한 데이터가 1500개일 가능성이 높다.
        // 즉, 현재 용적량의 기대치에 근접할 가능성이 높기 때문에 일단은 용적량을 일단 절반으로만 줄이는 것이다.
        // (또한 그만큼 데이터를 쓰지 않더라도 삭제 과정에서 용적량을 줄이기 때문에 크게 문제되진 않는다.)

        for (int i = 0; i < size; i++) {
            array[i] = null;
        }

        size = 0;
        resize();

    }

    /**
     * 스택에 요소가 비어있는지를 반환합니다.
     *
     * @return 스택에 요소가 없을 경우 {@code true}, 그 외의 경우 {@code false}를 반환
     */
    @Override
    public boolean empty() {
        // 모든 요소들을 하나씩 검사해줄 필요는 없다. size 변수가 0이면 데이터가 없다는 뜻이므로
        return size == 0;
    }

    // clone은 기존에 있던 객체를 파괴하지 않고 요소들이 동일한 객체를 새로 하나 만드는 것이다.
    // toArray는 사용자가 main 함수에서 특정 배열로 반환받고싶다거나 복사하고 싶을 때 Stack에 저장된 데이터들을 배열로 반환해주는 역할.
    // 마지막으로 sort()메소드는 말 그대로 정렬.

    // 주소만 복사하는 얕은 복사가 아닌 요소를 복제한 깊은 복사
    // 단순히 = 연산자로 객체를 복사하게 되면 '주소'를 복사하는 것이기 때문에
    // 복사한 객체에서 데이터를 조작할 경우 원본 객체까지 영향을 미친다. 즉 얕은 복사(shallow copy)가 된다는 것이다.
    // 이러한 것을 방지하기 위해서 깊은 복사를 하는데, 이 때 필요한 것이 바로 clone()이다.
    // Object에 있는 메소드이지만 접근제어자가 protected로 되어있어 구현해야 할 경우 반드시 Cloneable 인터페이스를 implement 해야한다.
    // 즉, public class Stack<E> implements StackInterface<E> 에 Cloneable도 추가해주어야 한다.

    @Override
    public Stack<?> // Object
                    clone() throws CloneNotSupportedException {

        Stack<?> cloneStack = (Stack<?>) super.clone();
        cloneStack.array = new Object[size];
        System.arraycopy(array, 0, cloneStack.array, 0, size);
        // TODO: copy mutable state here, so the clone can't change the internals of the original
        return cloneStack;
    }


    public static void main(String[] args) {
        T[] a = new T[10];
        System.out.println(a.length); // 배열의 length는 전체 용적.
        a[1] = new T();
        System.out.println(a.length);

    }
}
