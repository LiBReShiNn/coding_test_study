package kakao2022.level2_1;

import java.util.Map;
import java.util.TreeMap;

public class Solution_8 {
    public int[] solution(int[] fees, String[] records) {
        int IN = 0;
        int OUT = 1;
        int end = timeToMin("23:59");
        Map<String, int[]> map = new TreeMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String carNo = split[1];
            String way = split[2];
            if (!map.containsKey(carNo)) {
                map.put(carNo, new int[2]);
            }
            map.get(carNo)[0] += "IN".equals(way) ? -timeToMin(time) : timeToMin(time);
            map.get(carNo)[1] = "IN".equals(way) ? IN : OUT;
        }
        for (int[] value : map.values()) {
            value[0] += value[1] == IN ? end : 0;
        }
        return map.values().stream().mapToInt(v -> calculateFee(fees, v[0])).toArray();
    }

    private int timeToMin(String hhmm) {
        String[] split = hhmm.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private int calculateFee(int[] fees, int minutes) {
        if (minutes <= fees[0]) return fees[1];
        return fees[1] + (int) Math.ceil((minutes - fees[0]) / (double) fees[2]) * fees[3];
    }
}
