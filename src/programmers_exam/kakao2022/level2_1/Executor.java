package programmers_exam.kakao2022.level2_1;

import java.util.Arrays;

public class Executor {

    public static void main(String[] args) {

//        Solution sol = new Solution();
        Solution_16 sol = new Solution_16();

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(sol.solution(fees, records)));
    }

}
