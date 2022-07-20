package programmers_exam.kakao2022.level2_2;

import java.util.StringTokenizer;

public class Solution_4 {
    public static int solution(int n, int k) {

        String str = Integer.toString(n, k);

        StringTokenizer st = new StringTokenizer(str, "0");

        int count = 0;

        while(st.hasMoreTokens())
            if(isPrimeNumber(st.nextToken())) count++;

        return count;
    }

    public static boolean isPrimeNumber(String s) {

        long n = Long.parseLong(s);

        if(n==1) return false;

        long sqrt = (long)Math.sqrt(n);

        for(int i=2; i<sqrt+1; i++)
            if(n%i == 0) return false;

        return true;
    }
}
