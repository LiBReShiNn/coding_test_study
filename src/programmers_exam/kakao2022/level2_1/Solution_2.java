package programmers_exam.kakao2022.level2_1;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Solution_2 {
    public int[] solution(int[] fees, String[] records) {
        FeeTable feeTable = new FeeTable(fees[0], fees[1], fees[2], fees[3]);

        Records record = Arrays.stream(records)
                .map(Record::parse)
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(Record::getCar), Records::new));

        return record.calculateFees(feeTable).stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private static class Car implements Comparable<Car> {
        private final String number;

        public Car(String number) {
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return Objects.equals(number, car.number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }

        @Override
        public int compareTo(Car other) {
            return this.number.compareTo(other.number);
        }
    }

    private static class Records {
        private static final LocalTime DEFAULT_OUT_TIME = LocalTime.parse("23:59");
        private final Map<Car, List<Record>> records;

        public Records(Map<Car, List<Record>> records) {
            this.records = records;
        }

        public List<Integer> calculateFees(FeeTable feeTable) {
            return records.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(Map.Entry::getValue)
                    .map(record -> calculateFee(record, feeTable))
                    .collect(Collectors.toList());
        }

        private Integer calculateFee(List<Record> record, FeeTable feeTable) {
            Collections.sort(record);

            int index = 0;
            int differ = 0;

            while (index < record.size()) {
                differ += calculateDiffer(record, index);
                index += 2;
            }

            if (differ <= feeTable.getBaseTimeMinutes()) {
                return feeTable.getBaseFee();
            }

            int withoutBase = differ - feeTable.getBaseTimeMinutes();
            int remainder = withoutBase % feeTable.getUnitTimeMinutes() > 0 ? 1 : 0;

            return feeTable.getBaseFee() + (remainder + withoutBase / feeTable.getUnitTimeMinutes()) * feeTable.unitFee;
        }

        private Integer calculateDiffer(List<Record> record, int index) {
            Record in = record.get(index);
            Record out = getNextRecord(record, in.getCar(), index);

            return in.getDifferFrom(out);
        }

        private Record getNextRecord(List<Record> record, Car car, int index) {
            if (index + 1 >= record.size()) {
                return new Record(RecordType.OUT, car, DEFAULT_OUT_TIME);
            }

            return record.get(index + 1);
        }
    }

    private static class Record implements Comparable<Record> {
        private final RecordType type;
        private final Car car;
        private final LocalTime time;

        public Record(RecordType type, Car car, LocalTime time) {
            this.type = type;
            this.car = car;
            this.time = time;
        }

        public static Record parse(String rawRecord) {
            String[] record = rawRecord.split(" ");
            LocalTime time = LocalTime.parse(record[0]);
            Car car = new Car(record[1]);
            RecordType recordType = RecordType.findType(record[2]);

            return new Record(recordType, car, time);
        }

        public Car getCar() {
            return car;
        }

        public boolean isOut() {
            return type.isOut();
        }

        public boolean isInBaseTime(Record other, int baseTime) {
            return getDifferFrom(other) <= baseTime;
        }

        public Integer getDifferFrom(Record other) {
            int here = TimeUtils.toMinutes(time);
            int otherTime = TimeUtils.toMinutes(other.time);
            return Integer.max(here, otherTime) - Integer.min(here, otherTime);
        }

        @Override
        public int compareTo(Record o) {
            return this.time.compareTo(o.time);
        }
    }

    private static class TimeUtils {
        public static Integer toMinutes(LocalTime time) {
            return time.getHour() * 60 + time.getMinute();
        }
    }

    private enum RecordType {
        IN,
        OUT;

        public static RecordType findType(String type) {
            return Arrays.stream(values())
                    .filter(t -> t.name().equals(type))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public boolean isIn() {
            return IN.equals(this);
        }

        public boolean isOut() {
            return OUT.equals(this);
        }
    }

    private static class FeeTable {
        private final Integer baseTimeMinutes;
        private final Integer baseFee;
        private final Integer unitTimeMinutes;
        private final Integer unitFee;

        public FeeTable(Integer baseTimeMinutes, Integer baseFee,
                        Integer unitTimeMinutes, Integer unitFee) {
            this.baseTimeMinutes = baseTimeMinutes;
            this.baseFee = baseFee;
            this.unitTimeMinutes = unitTimeMinutes;
            this.unitFee = unitFee;
        }

        public Integer getBaseTimeMinutes() {
            return baseTimeMinutes;
        }

        public Integer getBaseFee() {
            return baseFee;
        }

        public Integer getUnitTimeMinutes() {
            return unitTimeMinutes;
        }

        public Integer getUnitFee() {
            return unitFee;
        }
    }
}
