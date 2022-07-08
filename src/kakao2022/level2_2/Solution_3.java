package kakao2022.level2_2;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution_3 {

    public int solution(int n, int k) {
        String s = Integer.toString(n, k);
        return (int) Arrays.stream(s.split("0"))
                .filter(p ->
                        !p.isEmpty()
                                && !p.equals("1")
                                && isPrime(BigInteger.valueOf(Long.parseLong(p)))
                                && (s.contains("0${p}0")
                                || s.contains("${p}0")
                                || s.contains("0${p}")
                                || s.contains(p))
                )
                .count();
    }

    private boolean isPrime(BigInteger n) {
        long l = 2;

        while (l <= Math.sqrt(n.doubleValue())) {
            if (n.remainder(BigInteger.valueOf(l)) == BigInteger.ZERO) return false;
            l++;
        }
        return true;
    }

}
