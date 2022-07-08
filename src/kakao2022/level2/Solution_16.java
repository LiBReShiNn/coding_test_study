package kakao2022.level2;

import java.util.Map;
import java.util.TreeMap;

public class Solution_16 {

    int parse(String time[]) {
        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
    }
    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> map = new TreeMap<>();
        for(String record : records) {
            String info[] = record.split(" ");
            map.put(info[1], map.getOrDefault(info[1], 0) + parse(info[0].split(":"))*(info[2].equals("IN") ? -1 : 1));
        }
        int i=0 , ans[] = new int[map.size()];
        for(String key : map.keySet()) {
            int time = map.get(key);
            if(time <= 0) time += 1439;
            ans[i] = fees[1];
            time -= fees[0]+1;
            if(time >= 0) ans[i] += (time/fees[2]+1)*fees[3];
            i++;
        }
        return ans;
    }

}
