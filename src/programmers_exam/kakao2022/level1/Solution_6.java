package programmers_exam.kakao2022.level1;

import java.util.*;

class Solution_6 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> reportCnt = new HashMap<>();
        Map<String, String> reportNames = new HashMap<>();
        for (String str : id_list) {
            reportCnt.put(str, 0);
            reportNames.put(str, "");
        }

        Set<String> set = new HashSet<>();
        for (String str : report)
            set.add(str);

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            StringTokenizer st = new StringTokenizer(it.next(), " ");
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            reportNames.replace(s1, reportNames.get(s1) + " " + s2);
            reportCnt.replace(s2, reportCnt.get(s2) + 1);
        }

        for (int i = 0; i < id_list.length; i++) {
            StringTokenizer st = new StringTokenizer(reportNames.get(id_list[i]), " ");
            while (st.hasMoreTokens())
                if (reportCnt.get(st.nextToken()) >= k)
                    answer[i]++;
        }

        return answer;
    }
}
