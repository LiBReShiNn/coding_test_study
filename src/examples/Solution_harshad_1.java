package examples;

public class Solution_harshad_1 {
    public boolean solution_1(int x) {

        String[] temp = String.valueOf(x).split("");

        int sum = 0;
        for (String s : temp) {
            sum += Integer.parseInt(s);
        }

        return x % sum == 0;

    }

    public boolean solution_2(int x) {
        int sum = String.valueOf(x).chars().map(ch -> ch - '0').sum();
        return x % sum == 0;
    }
}
