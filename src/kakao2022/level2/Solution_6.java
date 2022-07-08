package kakao2022.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution_6 {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> carNum = new ArrayList<>();
        String[] tmpRecord, tmpTime;
        int time = 0, number = 0;
        HashMap<Integer, int[]> map = new HashMap<>();   //차번호 - [입차시간, 누적시간]

        for (String s : records) {
            tmpRecord = s.split(" ");
            number = Integer.parseInt(tmpRecord[1]);
            if (!map.containsKey(number)) {
                carNum.add(number);
                map.put(number, new int[2]);
                map.get(number)[0] = -1;
            }
            tmpTime = tmpRecord[0].split(":");
            time = Integer.parseInt(tmpTime[0]) * 60 + Integer.parseInt(tmpTime[1]);
            if (map.get(number)[0] == -1) map.get(number)[0] = time;  //입차
            else {  //출차
                map.get(number)[1] += time - map.get(number)[0];
                map.get(number)[0] = -1;
            }
        }

        Collections.sort(carNum);
        int[] answer = new int[carNum.size()];
        int count = 0, tmp = 0;
        for (int i : carNum) {
            if (map.get(i)[0] != -1) map.get(i)[1] += (23 * 60 + 59) - map.get(i)[0];
            answer[count] = fees[1];
            if (map.get(i)[1] > fees[0]) {
                if ((map.get(i)[1] - fees[0]) % fees[2] != 0) {
                    answer[count] += (((map.get(i)[1] - fees[0]) / fees[2]) + 1) * fees[3];
                } else {
                    answer[count] += ((map.get(i)[1] - fees[0]) / fees[2]) * fees[3];
                }
            }

            count++;
        }
        return answer;
    }
}
