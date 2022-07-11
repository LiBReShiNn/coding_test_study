package stream;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BubbleSort {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Collections.addAll(list, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        bubbleSort8(list);
    }

    public static void bubbleSort8(List<Integer> list) {
        // counters: 0-passes, 1-swaps
        int[] counter = new int[2];
        IntStream.iterate(0, i -> i + 1)
                // output the beginning of the pass and increase the counter of passes
                .peek(i -> System.out.print((i == 0 ? "<pre>" : "<br>") + "Pass: " + counter[0]++))
                // repeat the passes through the list until
                // all the elements are in the correct order
                .anyMatch(i ->
                        IntStream
                                // pass through the list and
                                // compare adjacent elements
                                .range(0, list.size() - 1)
                                // if this element is greater than the next one
                                .filter(j -> list.get(j) > list.get(j + 1))
                                // then swap them
                                .peek(j -> Collections.swap(list, j, j + 1))
                                // output the list and increase the counter of swaps
                                .peek(j -> System.out.print(outputSwapped8(list, j, j + 1, counter[1]++)))
                                // if there are no swapped elements at the
                                // current pass, then this is the last pass
                                .count() == 0);
        // output total
        System.out.print("<br>Total: Passes=" + counter[0]);
        System.out.println(", swaps=" + counter[1] + "</pre>");
    }

    static String outputSwapped8(List<Integer> list, int e1, int e2, int counter) {
        return IntStream.range(0, list.size())
                .mapToObj(i -> i == e1 || i == e2 ?
                        // swapped elements are in bold
                        "<b>" + list.get(i) + "</b>" :
                        // other elements
                        "" + list.get(i))
                .collect(Collectors.joining(" ", "<br>", " | " + counter));
    }

//    output
//    Pass: 0
//            9 10 8 7 6 5 4 3 2 1 | 0
//            9 8 10 7 6 5 4 3 2 1 | 1
//            9 8 7 10 6 5 4 3 2 1 | 2
//            9 8 7 6 10 5 4 3 2 1 | 3
//            9 8 7 6 5 10 4 3 2 1 | 4
//            9 8 7 6 5 4 10 3 2 1 | 5
//            9 8 7 6 5 4 3 10 2 1 | 6
//            9 8 7 6 5 4 3 2 10 1 | 7
//            9 8 7 6 5 4 3 2 1 10 | 8
//    Pass: 1
//            8 9 7 6 5 4 3 2 1 10 | 9
//            8 7 9 6 5 4 3 2 1 10 | 10
//            8 7 6 9 5 4 3 2 1 10 | 11
//            8 7 6 5 9 4 3 2 1 10 | 12
//            8 7 6 5 4 9 3 2 1 10 | 13
//            8 7 6 5 4 3 9 2 1 10 | 14
//            8 7 6 5 4 3 2 9 1 10 | 15
//            8 7 6 5 4 3 2 1 9 10 | 16
//    Pass: 2
//            7 8 6 5 4 3 2 1 9 10 | 17
//            7 6 8 5 4 3 2 1 9 10 | 18
//            7 6 5 8 4 3 2 1 9 10 | 19
//            7 6 5 4 8 3 2 1 9 10 | 20
//            7 6 5 4 3 8 2 1 9 10 | 21
//            7 6 5 4 3 2 8 1 9 10 | 22
//            7 6 5 4 3 2 1 8 9 10 | 23
//    Pass: 3
//            6 7 5 4 3 2 1 8 9 10 | 24
//            6 5 7 4 3 2 1 8 9 10 | 25
//            6 5 4 7 3 2 1 8 9 10 | 26
//            6 5 4 3 7 2 1 8 9 10 | 27
//            6 5 4 3 2 7 1 8 9 10 | 28
//            6 5 4 3 2 1 7 8 9 10 | 29
//    Pass: 4
//            5 6 4 3 2 1 7 8 9 10 | 30
//            5 4 6 3 2 1 7 8 9 10 | 31
//            5 4 3 6 2 1 7 8 9 10 | 32
//            5 4 3 2 6 1 7 8 9 10 | 33
//            5 4 3 2 1 6 7 8 9 10 | 34
//    Pass: 5
//            4 5 3 2 1 6 7 8 9 10 | 35
//            4 3 5 2 1 6 7 8 9 10 | 36
//            4 3 2 5 1 6 7 8 9 10 | 37
//            4 3 2 1 5 6 7 8 9 10 | 38
//    Pass: 6
//            3 4 2 1 5 6 7 8 9 10 | 39
//            3 2 4 1 5 6 7 8 9 10 | 40
//            3 2 1 4 5 6 7 8 9 10 | 41
//    Pass: 7
//            2 3 1 4 5 6 7 8 9 10 | 42
//            2 1 3 4 5 6 7 8 9 10 | 43
//    Pass: 8
//            1 2 3 4 5 6 7 8 9 10 | 44
//    Pass: 9
//    Total: Passes=10, swaps=45
}
