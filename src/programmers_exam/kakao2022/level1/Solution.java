package programmers_exam.kakao2022.level1;

import java.util.*;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];
        //split tmp
        String[] repoter_bad;
        List<String> totalBads = new ArrayList<>(); // ["b","c", "b","c" ....]
        Map<String, List<String>> reportCollection = new HashMap<>(); // { "a":["b","c"], "b":["c"] }
        List<String> badsFromReporter; // ["b","c"] / ["c"] / ....
        List<String> badIds = new ArrayList<>(); // ["b","c"]

        for (String rp : report) {
            repoter_bad = rp.split(" ");
            badsFromReporter = reportCollection.get(repoter_bad[0]) != null ? reportCollection.get(repoter_bad[0]) : new ArrayList<>();

            if (!badsFromReporter.contains(repoter_bad[1])) {
                badsFromReporter.add(repoter_bad[1]);
                reportCollection.put(repoter_bad[0], badsFromReporter);
                totalBads.add(repoter_bad[1]);
            }
        }

        for (String id : id_list) {
            int f = Collections.frequency(totalBads, id);
            if (f > (k - 1)) {
                badIds.add(id);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            badsFromReporter = reportCollection.get(id_list[i]);
            if (badsFromReporter != null)
                for (String e : badsFromReporter) {
                    if (badIds.contains(e))
                        answer[i]++;
                }
        }

        return answer;
    }

}
