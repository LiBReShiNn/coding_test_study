package examples;

public class Solution_masking_1 {

    public String solution_1(String phone_number) {

        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }

    public String solution_2(String phone_number) {
        return phone_number.replaceAll(".(?=.{4})", "*");
    }
}
