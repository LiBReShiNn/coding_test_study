package programmers_exam.examples;

public class Solution_harshad {
    public boolean solution(int x) {

        if (x < 10) {
            return true;
        } else {
            int sum = 0;
            char[] elm = String.valueOf(x).toCharArray();
            for (int e : elm) {
                sum += e - 48;
            }
            return x % sum == 0;
        }
    }
}
