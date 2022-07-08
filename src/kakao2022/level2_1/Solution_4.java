package kakao2022.level2_1;

import java.util.LinkedList;
import java.util.TreeMap;

public class Solution_4 {
    static int[] fees;

    public int[] solution(int[] fees, String[] records) {
        this.fees = fees;

        LinkedList<String> time = new LinkedList<>();
        LinkedList<String> number = new LinkedList<>();
        TreeMap<String, Integer> pay = new TreeMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");
            if (!pay.containsKey(info[1])) {
                pay.put(info[1], 0);
            }

            if (!number.contains(info[1])) {
                time.add(info[0]);
                number.add(info[1]);
                continue;
            }
            int index = number.indexOf(info[1]);
            String start_time = time.get(index);
            time.remove(index);
            number.remove(index);
            pay.put(info[1], pay.get(info[1]) + calc_diff(start_time, info[0]));
        }

        if (!number.isEmpty()) {
            for (int i = 0; i < number.size(); i++) {
                System.out.println(time.get(i));
                pay.put(number.get(i), pay.get(number.get(i)) + calc_diff(time.get(i), "23:59"));
            }
        }
        int[] answer = new int[pay.size()];
        int i = 0;
        for (String key : pay.keySet()) {
            answer[i++] = calc_money(pay.get(key));
        }
        return answer;
    }

    static int calc_money(int diff) {

        if (diff <= fees[0]) return fees[1];
        diff -= fees[0];
        double n = diff * 1.0 / fees[2];
        return fees[1] + ((int) Math.ceil(n)) * fees[3];
    }

    static int calc_diff(String start_time, String end_time) {
        String[] start = start_time.split(":");
        String[] end = end_time.split(":");

        int st = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int et = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

        return et - st;
    }
}
