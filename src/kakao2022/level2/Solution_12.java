package kakao2022.level2;

import java.util.*;
import java.util.Map.Entry;

public class Solution_12 {
    public int[] solution(int[] fees, String[] records) {


        TreeMap<String, ArrayList<String>> inOut = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] split = records[i].split(" ");

            inOut.put(split[1], new ArrayList<>());
        }

        int[] answer = new int[inOut.size()];
        int cnt = 0;
        Iterator<Entry<String, ArrayList<String>>> entry = inOut.entrySet().iterator();

        while (entry.hasNext()) {

            Map.Entry<String, ArrayList<String>> map = entry.next();

            //System.out.println("[Key]:" + map.getKey() + " [Value]:" + map.getValue());

            ArrayList<Integer> time = new ArrayList<>();

            for (int i = 0; i < records.length; i++) {
                String[] split = records[i].split(" ");
                if (split[1].equals(map.getKey())) {
                    time.add(getTime(split[0]));
                }
            }

            int min = 0;

            if (time.size() % 2 == 1) {

                for (int i = 0; i < time.size(); i++) {

                    if (i % 2 == 0) {
                        min = min - time.get(i);
                    } else {
                        min = min + time.get(i);
                    }

                }

                min = min + getTime("23:59");

            } else {

                for (int i = 0; i < time.size(); i++) {

                    if (i % 2 == 0) {
                        min = min - time.get(i);
                    } else {
                        min = min + time.get(i);
                    }

                }

            }

            answer[cnt] = price(fees, min);
            cnt++;

        }

        return answer;
    }

    private int getTime(String s) {
        String[] time = s.split(":");

        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

    }

    private int price(int[] fees, int min) {

        int basePrice = fees[1];
        int baseTime = fees[0];
        int diviceTime = fees[2];
        int divicePrice = fees[3];

        if (min <= baseTime) {

            return basePrice;

        } else {

            int ceil = (int) Math.ceil((double) (min - baseTime) / diviceTime);

            return basePrice + ceil * divicePrice;

        }


    }
}
