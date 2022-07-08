package kakao2022.level2_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public int[] solution(int[] fees, String[] records) {

        //fees 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
        //records 시각 차량번호 내역

        // 시간은 누적해서 모두 더한다. 그리고 모두 뺀다.

        Fees std = new Fees(fees);
        List<Records> recordsList = Arrays.stream(records).sorted().map(Records::new).collect(Collectors.toList());

        HashMap<String, Integer> count = new HashMap<>();
        for (Records r : recordsList) {
            count.put(r.getCarNo(), count.getOrDefault(r.getCarNo(), 0) + 1);
        }

        for (Map.Entry<String, Integer> e : count.entrySet()) {
            if (e.getValue() % 2 == 1) {
                recordsList.add(new Records("23:59 " + e.getKey() + " OUT"));
            }
        }

        List<Records> in = recordsList.stream().filter(r -> r.getAction().equals("IN")).collect(Collectors.toList());
        List<Records> out = recordsList.stream().filter(r -> r.getAction().equals("OUT")).collect(Collectors.toList());

        HashMap<String, Integer> inTime = new HashMap<>();
        HashMap<String, Integer> outTime = new HashMap<>();

        for (Records r : in) {
            inTime.put(r.getCarNo(), inTime.getOrDefault(r.getCarNo(), 0) + r.getTime());
        }

        for (Records r : out) {
            outTime.put(r.getCarNo(), outTime.getOrDefault(r.getCarNo(), 0) + r.getTime());
        }

        return count.keySet().stream().sorted().collect(Collectors.toList()).stream().map(car -> {
            int parkingTime = Math.toIntExact((outTime.get(car) - inTime.get(car)));
            if (parkingTime < std.getTimeR()) {
                return (std.getFeeR());
            } else {
                int time = (parkingTime - std.getTimeR());
                return (std.getFeeR() + (int) Math.ceil(time / std.getTimeA()) * std.getFeeA());
//                int time = Math.toIntExact((parkingTime - std.timeR));
//                if (time % std.getTimeA() != 0) {
//                    return (std.getFeeR() + (time / std.getTimeA() + 1) * std.getFeeA());
//                } else {
//                    return (std.getFeeR() + (time / std.getTimeA()) * std.getFeeA());
//                }
            }
        }).mapToInt(Integer::intValue).toArray();

    }

    class Records {
        int time;
        String carNo;
        String action;

        public Records(String r) {
            String[] str = r.split(" ");
            String[] time = str[0].split(":");
            this.time = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
            this.carNo = str[1];
            this.action = str[2];
        }

        public int getTime() {
            return time;
        }

        public String getCarNo() {
            return carNo;
        }

        public String getAction() {
            return action;
        }
    }

    class Fees {

        int timeR;
        int feeR;
        int timeA;
        int feeA;

        Fees(int[] fees) {
            this.timeR = fees[0];
            this.feeR = fees[1];
            this.timeA = fees[2];
            this.feeA = fees[3];
        }

        public int getTimeR() {
            return timeR;
        }

        public int getFeeR() {
            return feeR;
        }

        public int getTimeA() {
            return timeA;
        }

        public int getFeeA() {
            return feeA;
        }
    }
}
