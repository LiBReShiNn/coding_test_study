package programmers_exam.examples;

class Solution_stars {
    StringBuilder sb = new StringBuilder();
    public void stars (int a, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}