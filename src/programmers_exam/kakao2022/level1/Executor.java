package programmers_exam.kakao2022.level1;

import java.util.Arrays;

public class Executor {

    public static void main(String[] args) {

//        Solution sol = new Solution();
        Solution_1_study sol = new Solution_1_study();

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] id_list = {"con", "ryan"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        System.out.println(Arrays.toString(sol.solution(id_list, report, k)));
    }

}
