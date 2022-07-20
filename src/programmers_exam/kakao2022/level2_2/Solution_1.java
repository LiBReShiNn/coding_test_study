package programmers_exam.kakao2022.level2_2;

public class Solution_1 {
    public int solution(int n, int k) {

        int ans = 0;
        // 진수 바꿔주는 함수를 사용하자!!!!
        String temp[] = Integer.toString(n, k).split("0");

        Loop:
        for (String t : temp) {
            if (t.length() == 0) continue;
            long a = Long.parseLong(t);
            if (a == 1) continue;
            for (int i = 2; i <= Math.sqrt(a); i++)
                if (a % i == 0) continue Loop;

            ans++;
        }
        return ans;
    }
}
