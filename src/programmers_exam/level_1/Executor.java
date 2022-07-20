package programmers_exam.level_1;

import java.util.Arrays;

public class Executor {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] lottos = {44, 1, 0, 0, 31, 25};
//        int[] lottos = {0, 0, 0, 0, 0, 0};
//        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
//        int[] win_nums = {38, 19, 20, 40, 15, 25};
//        int[] win_nums = {20, 9, 3, 45, 4, 35};

        System.out.println(Arrays.toString(sol.solution(lottos, win_nums)));
    }

}
