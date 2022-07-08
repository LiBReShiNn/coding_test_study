package kakao2022.level2_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Solution_15 {

    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < records.length; i++) {
            String arr[] = records[i].split(" ");
            String time[] = arr[0].split(":");
            int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            map.computeIfAbsent(arr[1], s -> new ArrayList<>()).add(min);
        }
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        int[] answer = new int[map.size()];
        int idx = 0;
        for (String key : keyList) {
            List<Integer> list = map.get(key);
            int time = 0;
            int price = fees[1];
            for (int i = 0; i < list.size() - 1; i += 2) {
                time += (list.get(i + 1) - list.get(i));
            }
            if (list.size() % 2 == 1)
                time += 1439 - list.get(list.size() - 1);
            //요금
            if (time > fees[0])
                price += (int) Math.ceil((time - fees[0]) / (double) fees[2]) * fees[3];
            answer[idx++] = price;
        }
        return answer;
    }

}
