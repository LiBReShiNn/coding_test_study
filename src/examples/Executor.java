package examples;

public class Executor {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//
//        Solution_stars stars = new Solution_stars();
//        Solution_distance distance = new Solution_distance();
        Solution_matrix matrixSum = new Solution_matrix();
        Solution_masking masking = new Solution_masking();
//        stars.stars(a, b);
//        int[][] arr1 = {{1, 2}, {2, 3}};
//        int[][] arr2 = {{3, 4}, {5, 6}};
        int[][] arr1 = {{1}, {2}};
        int[][] arr2 = {{3}, {4}};
//        System.out.println(Arrays.deepToString(matrixSum.solution(arr1, arr2)));
        System.out.println(masking.solution("01033334444"));
        System.out.println(masking.solution("027778888"));

    }

}
