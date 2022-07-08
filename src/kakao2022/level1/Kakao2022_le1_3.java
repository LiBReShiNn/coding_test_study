package kakao2022.level1;

import java.util.*;
import java.util.regex.Pattern;


class Kakao2022_le1_3 {

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = {};

        if (!validate(id_list, report, k)) {
            return answer;
        }

        Map<String, List<String>> reportCollection = new HashMap<>(); // { "a":["b","c"], "b":["c"] }

        List<String> badsFromReporter = new ArrayList<>(); // ["b","c"] / ["c"] / ....

        List<String> totalBads = getTotalBads(report, reportCollection, badsFromReporter);

        List<String> badIds = getBadIds(totalBads, id_list, k);

        return calculateSendingCnt(id_list, reportCollection, badsFromReporter, badIds);

    }

    boolean validate(String[] id_list, String[] report, int k) {
        // 한번에 한명의 유저 신고, 동일 유저 1회 통합
        // k번 이상 신고 유저 취합 발송 마지막에 answer

        //  k
        if (k < 1) {
            System.out.print("신고 횟수는 1 이상이어야 합니다");
            return false;
        }
        if (k > 200) {
            System.out.print("신고 횟수는 200 이하이어야 합니다");
            return false;
        }

        // id_list
        if (id_list.length < 2) {
            System.out.print("유저가 1명 입니다");
            return false;
        }
        if (id_list.length > 1000) {
            System.out.print("유저는 1000명 이상이 될 수 없습니다");
            return false;
        }
        for (String id : id_list) {
            if (id.length() < 1) {
                System.out.print("아이디는 1-10자의 알파벳 소문자로만 구성 되어야 합니다");
                return false;
            }
            if (id.length() > 10) {
                System.out.print("아이디는 1-10자의 알파벳 소문자로만 구성 되어야 합니다");
                return false;
            }
            String regexp = "^[a-z]*$";
            boolean flag = Pattern.matches(regexp, id);
            if (!flag) {
                System.out.print("아이디는 1-10자의 알파벳 소문자로만 구성 되어야 합니다");
                return false;
            }
        }

        // report
        if (report.length < 1) {
            System.out.print("신고가 없습니다");
            return false;
        }
        if (report.length > 200000) {
            System.out.print("신고가 200,000건 이상입니다");
            return false;
        }

        for (String rp : report) {
            if (rp.length() < 3) {
                System.out.print("잘못 된 신고 양식입니다");
                return false;
            }
            if (rp.length() > 21) {
                System.out.print("잘못 된 신고 양식입니다");
                return false;
            }
            String regexp = "^[a-z\\s]*$";
            boolean flag = Pattern.matches(regexp, rp);
            if (!flag) {
                System.out.print("잘못 된 신고 양식입니다");
                return false;
            }
        }

        return true;
    }

    private List<String> getTotalBads(String[] report, Map<String, List<String>> reportCollection, List<String> badsFromReporter) {

        //split tmp
        String[] repoter_bad;

        List<String> totalBads = new ArrayList<>(); // ["b","c", "b","c" ....]

        for (String rp : report) {
            repoter_bad = rp.split(" ");
            badsFromReporter = reportCollection.get(repoter_bad[0]) != null ? reportCollection.get(repoter_bad[0]) : new ArrayList<>();

            if (!badsFromReporter.contains(repoter_bad[1])) {
                badsFromReporter.add(repoter_bad[1]);
                reportCollection.put(repoter_bad[0], badsFromReporter);
                totalBads.add(repoter_bad[1]);
            }
        }

        return totalBads;

    }

    private List<String> getBadIds(List<String> totalBads, String[] id_list, int k) {
        List<String> badIds = new ArrayList<>(); // ["b","c"]

        for (String id : id_list) {
            int f = Collections.frequency(totalBads, id);
            if (f > (k - 1)) {
                badIds.add(id);
            }
        }

        return badIds;
    }

    private int[] calculateSendingCnt(String[] id_list, Map<String, List<String>> reportCollection, List<String> badsFromReporter, List<String> badIds) {

        int[] rt = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            badsFromReporter = reportCollection.get(id_list[i]);
            if (badsFromReporter != null)
                for (String e : badsFromReporter) {
                    if (badIds.contains(e))
                        rt[i]++;
                }
        }

        return rt;

    }


}
