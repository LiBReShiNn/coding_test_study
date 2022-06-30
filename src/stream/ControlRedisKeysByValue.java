package stream;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControlRedisKeysByValue {

    @Autowired
    // RedisTemplate<K,V> Generic
    private RedisTemplate<String, String> redisTemplate;

    public void addKey(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            log.error("### Redis Set Key Error ::: {}", e.getMessage());
        }
    }

    public String getValue(String key) {
        String value = "";
        try {
            if (redisTemplate.hasKey(key)) {
                value = redisTemplate.opsForValue().get(key);
            }
        } catch (Exception e) {
            log.error("### Redis Get Value Error ::: {}", e.getMessage());
        }
        return value;
    }

    // hash (opsForHash)
    public void setHashOps(String key, HashMap<Object, Object> value) {
        redisTemplate.opsForHash().putAll(key, value);
    }

    public Map<Object, Object> getHashOps(String hashKey) {
        return redisTemplate.opsForHash().entries(hashKey);
    }

    public void removeKey(String Key) {
        redisTemplate.delete(Key);
    }

    public Object actionByValue(Object value, String action, Long n) {

        Set<String> redisKeys = redisTemplate.keys("*");

        Stream<String> stream;
        if (Pattern.matches("^[0-9]*$", String.valueOf(value))) {
            List<String> keys = new ArrayList<>();
            for (String key : redisKeys) {
                if (redisTemplate.opsForHash().entries(key).containsValue(Integer.valueOf(String.valueOf(value)))) {
                    keys.add(key);
                }
            }
            stream = keys.stream();
        } else {

            // map 은 변환된 처리 값이 들어감.
//        Stream<Object> stream = redisKeys.stream().map(k -> redisTemplate.opsForHash().entries(k));// "list": [{"store_id": 678, "role": "MANAGER", "user_id": "36", "user_name": "phoya", "isAdmin": "true", "email": "phoya@plendar.com"}, {"store_id": 631, "role": "MANAGER", "user_id": "36", "user_name": "phoya", "isAdmin": "true", "email": "phoya@plendar.com"}]
//        Stream<Object> stream = redisKeys.stream().map(k -> redisTemplate.opsForHash().entries(k).containsValue(value)); // "list": [true, true, true, true]

            // filter는 조건에 만족하는 key를 뱉는다.
            // filter가 스트링이어서 value가 string이 아니면 동작을 안함.
            stream = redisKeys.stream().filter(k -> redisTemplate.opsForHash().entries(k).containsValue(value)); // "list": ["1cb59d34bea7471c8cd073d0395fb13e", "de5476d4ce424ba58cb59b8123f385b9", "ee504c68023d45c1bc460efc3839b7c5", "f46f3dad5c484c0e9450527a688bd323", "22ccb246ac8c4b3d80186457a1b4a41a"]

            // stream은 데이터를 가공해서 사용하지 않는다. storeId 가 int값인 것을 바꿔서 사용할 수 없다.
//        Stream<String> stream = redisKeys.stream().filter(k -> redisTemplate.opsForHash().entries(k).entrySet().stream().forEach(sk-> {
//            sk = sk.getValue().toString();
//        }).containsValue(value)); // 불가능
        }

        if (action.equals("select")) {
            return stream.collect(Collectors.toList());
        }
        if (action.equals("delete")) {
            // 스트림의 첫 번째 n개 요소를 삭제한 후 이 스트림의 나머지 요소로 구성된 스트림을 반환합니다. 이 스트림에 n개 미만의 요소가 포함되어 있으면 빈 스트림이 반환됩니다.
            stream.skip(n).forEach(k -> redisTemplate.delete(String.valueOf(k)));
            return "삭제하였습니다";
        }
        return "지정되지 않은 요청입니다";

    }

}
