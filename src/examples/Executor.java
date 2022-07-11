package examples;

import kakao2020.level_1_1.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Executor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        Solution_stars stars = new Solution_stars();
        Solution_distance distance = new Solution_distance();
//        stars.stars(a, b);
        System.out.println(Arrays.toString(distance.solution(a, b)));

    }

}
