package programmers_exam.kakao2022.level2_2;

import java.util.Arrays;

public class Solution {

    public int solution(int n, int k) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        String[] nums = sb.toString().split("0");

        long answer = Arrays.stream(nums).filter(num -> !num.equals("")).mapToLong(Long::parseLong).map(num -> {
            if (num == 1) return 0;
            long max = (long) Math.sqrt(num);
            for (long i = 2; i <= max; i++) {
                if (num % i == 0) return 0;
            }
            return 1;
        }).sum();

        return (int) answer;

        // 자료형의 범위가 문제가 된다.

        /*
            문자형
            (signed) char            1 byte    -128 ~ 127
            unsigned char            1 byte    0 ~ 255
            wchar_t                  2 byte    0 ~ 65,535
            정수형
            bool                     1 byte    0 ~ 1
            (signed) short (int)     2 byte    -32,768 ~ 32,767
            unsigned short (int)     4 byte    0 ~ 65,535
            (signed) int             4 byte    -2,147,483,648 ~ 2,147,483,647
            unsigned int             4 byte    0 ~ 4,294,967,295
            (signed) long (int)      4 byte    -2,147,483,648 ~ 2,147,483,647
            unsigned long (int)      4 byte    0 ~ 4,294,967,295
            __int8                   1 byte    -128 ~ 127
            __int16                  2 byte    -32,768 ~ 32,767
            __int32                  4 byte    -2,147,483,648 ~ 2,147,483,647
            __int64                  8 byte    -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
        */
    }
}
