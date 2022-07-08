package kakao2022.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class Solution_14 {


    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        int normalTime = fees[0];
        int normalFee = fees[1];
        int dt = fees[2];
        int feeByDt = fees[3];

        HashMap<String, Stack<Integer>> timeCount = new HashMap<>();
        HashMap<String, Integer> totalTimes = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            int time = getTime(split[0]);
            String number = split[1];
            if (timeCount.containsKey(number)) {
                Stack<Integer> stack = timeCount.get(number);
                if (stack.isEmpty()) {
                    stack.add(time);
                } else {
                    int t = time - stack.pop();
                    totalTimes.put(number, totalTimes.get(number) + t);
                }
            } else {
                totalTimes.put(number, 0);
                Stack<Integer> stack = new Stack<>();
                stack.add(time);
                timeCount.put(number, stack);
            }
        }
        for (String key : timeCount.keySet()) {
            if (!timeCount.get(key).isEmpty()) {
                int t = 23 * 60 + 59 - timeCount.get(key).pop();
                totalTimes.put(key, totalTimes.get(key) + t);
            }
        }
        ArrayList<String> keys = new ArrayList<>(totalTimes.keySet());
        Collections.sort(keys);
        answer = new int[keys.size()];
        int idx = 0;
        for (String key : keys) {
            int totalTime = totalTimes.get(key);
            if (normalTime >= totalTime) {
                answer[idx++] = normalFee;
            } else {
                answer[idx++] = normalFee + ((int) Math.ceil((double) (totalTime - normalTime) / dt)) * feeByDt;
            }
        }
        return answer;
    }

    private int getTime(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

}
