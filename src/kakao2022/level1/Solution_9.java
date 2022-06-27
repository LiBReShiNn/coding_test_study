package kakao2022.level1;

import java.util.*;

class Solution_9 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];

        HashMap<String, Integer> report_map = new HashMap<String, Integer>();
        for(int i = 0 ; i < report.length ; i++) {
            report_map.put(report[i], 0);
        }

        HashMap<String, Integer> id_map = new HashMap<String, Integer>();
        HashMap<String, Integer> emailCount_map = new HashMap<String, Integer>();
        for(int i = 0 ; i < id_list.length ; i++) {
            id_map.put(id_list[i], 0);
            emailCount_map.put(id_list[i], 0);
        }

        for(String key : report_map.keySet()) {
            String[] temp = key.split(" ");

            id_map.put(temp[1], id_map.get(temp[1]) + 1);
        }

        for(String key : report_map.keySet()) {
            String[] temp = key.split(" ");

            if(id_map.get(temp[1]) >= k) {
                emailCount_map.put(temp[0], emailCount_map.get(temp[0]) + 1);
            }
        }

        for(int i = 0 ; i < id_list.length ; i++) {
            answer[i] = emailCount_map.get(id_list[i]);
        }

        return answer;
    }
}