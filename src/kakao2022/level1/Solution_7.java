package kakao2022.level1;


import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution_7 {
    public int[] solution(String[] idList, String[] report, int k) {
        Supplier<Stream<String[]>> reportPairList = () -> Arrays.stream(report).distinct().map(s -> s.split(" "));
        List<String> blackList = reportPairList.get().collect(Collectors.groupingBy(strings -> strings[1])).entrySet().stream().filter(stringListEntry -> stringListEntry.getValue().size() >= k).map(Map.Entry::getKey).collect(Collectors.toList());
        Map<String, Long> mailCountMap = getMailCountMap(reportPairList.get(), blackList);
        return Arrays.stream(idList).mapToInt(value -> Math.toIntExact(mailCountMap.get(value) != null ? mailCountMap.get(value) : 0)).toArray();
    }

    private Map<String, Long> getMailCountMap(Stream<String[]> reportPairList, List<String> blackList) {
        Map<String, Long> map = new HashMap<>();

        reportPairList.collect(Collectors.groupingBy(strings -> strings[0])).forEach((key, value) -> map.put(key, value.stream().map(strings -> strings[1]).filter(blackList::contains).count()));
        return map;
    }
}