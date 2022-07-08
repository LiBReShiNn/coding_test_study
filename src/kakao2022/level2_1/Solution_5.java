package kakao2022.level2_1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution_5 {
    private static class Machine {
        private final int baseTime;
        private final int baseFee;
        private final int unitTime;
        private final int unitFee;

        public Machine(int baseTime, int baseFee, int unitTime, int unitFee) {
            this.baseTime = baseTime;
            this.baseFee = baseFee;
            this.unitTime = unitTime;
            this.unitFee = unitFee;
        }

        public int totalFee(int minuate) {
            int result = 0;

            if (minuate <= baseTime) {
                return baseFee;
            }

            if (minuate > baseTime) {
                result += baseFee;
                minuate -= baseTime;
            }

            result += ((int) Math.ceil((float) minuate / unitTime) * unitFee);
            return result;
        }
    }

    private static class CarLog {
        private String carId;
        private int enterTime;
        private int leaveTime;

        public CarLog(String carId, int enterTime) {
            this.carId = carId;
            this.enterTime = enterTime;
            this.leaveTime = 1439;
        }

        public String getCarId() {
            return carId;
        }

        public void updateLeaveTime(int leaveTime) {
            this.leaveTime = leaveTime;
        }

        public int stayTime() {
            return leaveTime - enterTime;
        }
    }

    private int minuate(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3));

        return hour * 60 + min;
    }

    public int[] solution(int[] fees, String[] records) {

        Comparator<String> comparator = (v1, v2) -> Integer.parseInt(v1) - Integer.parseInt(v2);
        Map<String, CarLog> logs = new HashMap<>();
        Map<String, Integer> prices = new TreeMap<>(comparator);

        Machine parking = new Machine(fees[0], fees[1], fees[2], fees[3]);

        for (String record : records) {
            String[] tokens = record.split(" ");
            String carId = tokens[1];
            String command = tokens[2];

            if ("IN".equals(command)) {
                logs.put(carId, new CarLog(carId, minuate(tokens[0])));
            } else if ("OUT".equals(command)) {
                CarLog log = logs.get(carId);
                log.updateLeaveTime(minuate(tokens[0]));
                prices.put(carId, prices.getOrDefault(carId, 0) + log.stayTime());
                logs.remove(carId);
            }
        }

        for (CarLog log : logs.values()) {
            prices.put(log.getCarId(), prices.getOrDefault(log.getCarId(), 0) + log.stayTime());
        }

        return prices.values().stream().mapToInt(parking::totalFee).toArray();
    }
}
