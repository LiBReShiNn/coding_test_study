package collections;

import java.util.Arrays;

public class Prime {

    public int solution(int n, int k) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        int[] checks = Arrays.stream(sb.toString().split("0")).filter(num -> !num.equals("")).mapToInt(Integer::parseInt).toArray();

        int maxNum = 1000000;
        boolean[] isPrime = new boolean[maxNum + 1];
        Arrays.fill(isPrime, true);

        // 소수는 true
        // 0, 1은 소수가 아니므로 false
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= maxNum; i++) {
            // 만약 i가 소수 혹은 아직 지워지지 않았다면
            if (isPrime[i]) {
                // i의 배수 j들에 대해 isPrime[j] = false; 로 둔다.
                // i*i미만의 배수는 이미 지워졌으므로 신경쓰지 않는다.
                for (int j = i * i; j <= maxNum; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        // 1 ~ 120 사이의 소수 출력
        return Arrays.stream(checks).map(num -> {
            for (int i = 1; i <= maxNum; i++) {
                if (isPrime[i])
                    if (i == num) return 1;
            }
            return 0;
        }).sum();
    }
}
