package programmers_exam.examples;

public class Solution_masking {

    public String solution(String phone_number) {

        int index = phone_number.length() - 4;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append("*");
        }
        sb.append(phone_number.substring(index));
        return sb.toString();
    }
}
