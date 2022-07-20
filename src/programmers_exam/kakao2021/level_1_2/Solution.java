package programmers_exam.kakao2021.level_1_2;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public int solution(String s) {

        final List<String> numStr = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        for (String ns : numStr) {
            if (s.contains(ns)) {
                s = s.replace(ns, String.valueOf(numStr.indexOf(ns)));
            }
        }
        int answer = Integer.parseInt(s);
        return answer;
    }

}
