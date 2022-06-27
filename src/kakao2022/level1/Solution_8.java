package kakao2022.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution_8 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<HashSet<String>> reported = new ArrayList<HashSet<String>>();
        HashMap<String, Integer> idIdx = new HashMap<String, Integer>();

        for (int i = 0; i < id_list.length; i++) {
            idIdx.put(id_list[i], i);
            reported.add(i, new HashSet<String>());
        }

        for (String names : report) {
            String reportPerson = names.split(" ")[0];
            String reportedPerson = names.split(" ")[1];

            reported.get(idIdx.get(reportedPerson)).add(reportPerson);
        }

        for (HashSet<String> set : reported) {
            if (set.size() >= k) {
                for (String name : set) {
                    answer[idIdx.get(name)]++;
                }
            }
        }

        return answer;
    }
}