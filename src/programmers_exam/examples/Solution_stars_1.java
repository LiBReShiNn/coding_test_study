package programmers_exam.examples;

import java.util.stream.IntStream;

public class Solution_stars_1 {

    public void stars(int a, int b) {

        StringBuilder sb = new StringBuilder();
        IntStream.range(0, a).forEach(s -> sb.append("*"));
        IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));
    }

}
