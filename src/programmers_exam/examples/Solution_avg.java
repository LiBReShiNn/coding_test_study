package programmers_exam.examples;

import java.util.Arrays;

public class Solution_avg {

    public double solution(int[] arr) {

        return Arrays.stream(arr).asDoubleStream().average().getAsDouble();

    }
}
