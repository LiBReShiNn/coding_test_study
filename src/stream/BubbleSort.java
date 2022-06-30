package Stream;

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
                .peek(i -> System.out.print((i==0?"<pre>":"<br>")+"Pass: "+counter[0]++))
                // repeat the passes through the list until
                // all the elements are in the correct order
                .anyMatch(i -> IntStream
                        // pass through the list and
                        // compare adjacent elements
                        .range(0, list.size() - 1)
                        // if this element is greater than the next one
                        .filter(j -> list.get(j) > list.get(j + 1))
                        // then swap them
                        .peek(j -> Collections.swap(list, j, j + 1))
                        // output the list and increase the counter of swaps
                        .peek(j -> System.out.print(outputSwapped8(list,j,j+1,counter[1]++)))
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
}
