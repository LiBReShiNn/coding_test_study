package programmers_exam.kakao2022.level2_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution_3 {
    public int[] solution(int[] fees, String[] records) {
        return Arrays.stream(records)
                .map(s1 -> {
                    String[] splitted = s1.split(" ");
                    return new Triple(getMinute(splitted[0]), splitted[1], splitted[2].equals("IN") ? Status.In : Status.Out);
                })
                .collect(Collectors.groupingBy(triple -> triple.second))
                .entrySet()
                .stream()
                .map(stringListEntry -> {
                    Stack<Triple> stack = new Stack<>();
                    int time = 0;
                    int total = 0;

                    for (Triple v : stringListEntry.getValue()) {
                        switch (v.third) {
                            case In:
                                time += v.first;
                                stack.push(v);
                                break;
                            case Out:
                                time = v.first - time;
                                total += time;
                                time = 0;

                                stack.pop();
                                break;
                        }
                    }
                    if (!stack.isEmpty()) {
                        total += getMinute("23:59") - stack.peek().first;
                        stack.pop();
                    }
                    return new Pair(stringListEntry.getKey(), total < fees[0] ? fees[1] : (int) (fees[1] + Math.ceil(((double) total - fees[0]) / fees[2]) * fees[3]));
                })
                .sorted(Comparator.comparing(o -> o.first))
                .mapToInt(pair -> pair.second)
                .toArray();
    }

    private int getMinute(String strDate) {
        String[] separatedTime = strDate.split(":");
        int hour = Integer.parseInt(separatedTime[0]);
        int minute = Integer.parseInt(separatedTime[1]);
        return hour * 60 + minute;
    }

    static class Pair {
        String first;

        int second;

        Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Triple {
        int first;

        String second;

        Status third;

        Triple(int first, String second, Status third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    enum Status {
        In, Out
    }
}
