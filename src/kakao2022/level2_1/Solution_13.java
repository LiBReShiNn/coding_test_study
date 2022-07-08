package kakao2022.level2_1;

import java.util.HashMap;
import java.util.TreeMap;

public class Solution_13 {
    HashMap<String, Integer> inMap = new HashMap<>();
    TreeMap<String, Integer> feeMap = new TreeMap<>();

    static int LAST_TIME = 1439;

    public int[] solution(int[] fees, String[] records) {
        // in, out map init
        for (String record : records) {
            String[] split = record.split(" "); // 0 : time, 1 : num , 2: IN, OUT

            if (split[2].equals("IN")) {
                inMap.put(split[1], changeTimeToInt(split[0]));
            } else {
                feeMap.put(split[1], feeMap.getOrDefault(split[1], 0) + changeTimeToInt(split[0]) - inMap.get(split[1]));
                inMap.remove(split[1]);
            }
        }

        for (String num : inMap.keySet()) {
            feeMap.put(num, feeMap.getOrDefault(num, 0) + LAST_TIME - inMap.get(num));
        }

        int cur = 0;
        int[] result = new int[feeMap.size()];

        for (String num : feeMap.keySet()) {
            result[cur++] = calcFee(fees, feeMap.get(num));
        }

        return result;
    }

    public int changeTimeToInt(String time) {
        String[] hourMin = time.split(":");
        return Integer.parseInt(hourMin[0]) * 60 + Integer.parseInt(hourMin[1]);
    }

    public int calcFee(int[] fees, int time) {
        if (time < fees[0]) return fees[1];
        int money = 0;
        return fees[1] + (int) Math.ceil(((double) (time - fees[0]) / fees[2])) * fees[3];
    }
}
