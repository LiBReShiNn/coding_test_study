package examples;

import java.util.stream.LongStream;

public class Solution_distance {

    public long[] solution(int x, int n) {
        long[] answer = {};
        for (int i = 0; i < n; i++) {
            answer = LongStream.range(1, n + 1).map(nn -> x * nn).toArray();
        }

        return answer;
    }

}
