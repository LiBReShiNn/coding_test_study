package examples;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_hash {

    public int solution(int[] nums) {

//        int get = nums.length / 2;
        int[] poket = Arrays.stream(nums).distinct().toArray();

//        if (poket.length <= get) {
//            return (int) Arrays.stream(poket).count();
//        }
//        return get;

        return Math.min(poket.length, nums.length / 2);

        // int[]는 boxing을 해야 Collection<객체>로 만들어줄수 있다. boxing!!!!
//        return Math.min(Arrays.stream(nums).distinct().boxed().collect(Collectors.toSet()).size(), nums.length/2);

    }

}
