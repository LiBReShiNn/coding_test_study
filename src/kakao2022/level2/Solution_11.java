package kakao2022.level2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_11 {

    private static class Parking {
        private int minute;
        private String number;
        private Type type;

        Parking(String minute, String number, String type) {
            String[] split = minute.split(":");
            int hour = Integer.parseInt(split[0]) * 60;
            int minute1 = Integer.parseInt(split[1]);
            this.minute = hour + minute1;
            this.number = number;
            this.type = Type.valueOf(type);
        }

        public String getNumber() {
            return number;
        }

        public int getMinute() {
            return minute;
        }
    }

    private enum Type {
        IN, OUT
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Parking>> collect = Arrays.stream(records).map(r -> {
            String[] split = r.split(" ");
            return new Parking(split[0], split[1], split[2]);
        }).collect(Collectors.groupingBy(Parking::getNumber));

        return collect.keySet().stream().sorted().mapToInt(s -> getPrice(fees,collect.get(s))).toArray();
    }
    private int getPrice(int[] fees, List<Parking> parking) {
        String number = parking.get(0).getNumber();
        if (parking.size() % 2 == 1)
            parking.add(new Parking("23:59", number, "OUT"));

        int totalTime = 0;
        for (int i = 0; i < parking.size(); i += 2) {
            int parkTime = parking.get(i + 1).getMinute() - parking.get(i).getMinute();
            totalTime = totalTime + parkTime;
        }

        int round = (int) Math.ceil((double) (totalTime - fees[0]) / fees[2]);
        return totalTime <= fees[0] ? fees[1] : fees[1] + round * fees[3];

    }

}
