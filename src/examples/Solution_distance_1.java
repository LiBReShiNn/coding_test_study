package examples;

public class Solution_distance_1 {

    public long[] solution_1(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }
        return answer;
    }

    public long[] solution_2(int x, int n) {
        long[] answer = new long[n];
        long sum = 0;
        for (int i = 0; i < answer.length; i++) {
            sum += x;
            answer[i] = sum;
        }
        return answer;
    }

    public long[] solution_3(long x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = x * (i + 1);
        }
        return answer;
    }

}
