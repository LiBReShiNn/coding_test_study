package kakao2022.level2_2;

public class Solution_2 {

    public int solution(int n, int k) {
        int answer = 0;
        String[] split = Long.toUnsignedString(n, k)
                .replaceAll("[0]+", "0")
                .split("0");

        for (String str : split) {
            if (isPrime(Long.parseLong(str))) {
                System.out.println(str);
                answer++;
            }
        }
        return answer;
    }
    public boolean isPrime(long number) {
        if(number < 2) return false;
        if(number == 2) return true;
        for(int i = 2; i <= (int) Math.sqrt(number); i++) {
            if(number % i == 0)  return false;
        }
        return true;
    }

}
