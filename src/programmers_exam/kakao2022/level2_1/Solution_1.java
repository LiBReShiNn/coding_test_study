package programmers_exam.kakao2022.level2_1;

import java.util.TreeMap;

public class Solution_1 {

    //fees 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
    //records 시각 차량번호 내역
    public int timeToInt(String time) {
        String temp[] = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    public int[] solution(int[] fees, String[] records) {

        // TreeMap 흑적트리. 자동으로 정렬되어서 값이 입력된다. (오름차순, 유니코드 순)
        // 입력시 자동정렬 수행되므로 HashMap보다 추가, 삭제가 오래 걸린다.
        // 부모 키값과 비교하여 키값이 낮은 것은 왼쪽 높은 것은 오르쪽 자식 노드에 Map.Entry객체를 저장한다

        TreeMap<String, Integer> map = new TreeMap<>();

        for (String record : records) {
            String temp[] = record.split(" ");
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
        }
        int idx = 0, ans[] = new int[map.size()];
        for (int time : map.values()) {
            if (time < 1) time += 1439;
            time -= fees[0];
            int cost = fees[1];
            if (time > 0)
                cost += (time % fees[2] == 0 ? time / fees[2] : time / fees[2] + 1) * fees[3];

            ans[idx++] = cost;
        }
        return ans;
    }
}
