package collections;

public class Stack_Radix {

    // 진수 변환 프로그램

    // top은 자료의 위치를 가리킨다.
    int[] stack = {};
    int top = -1;

    void push(int x) {
        stack[++top] = x; // 포인터를 움직이고 대입한다.
    }

    int pop() {
        return stack[top--]; // 먼저 값을 꺼내고 포인터의 위치를 이동시킨다.
    }

    public int getRadix(int n, int k) {

        // 16진수...
        char[] str = "0123456789ABCDEF".toCharArray();

        while (n > 0) {
            push(n % k);
            n = n / k;
        }

        while (top != -1) {
            System.out.println(str[pop()]);
        }

        return 0;

    }

}
