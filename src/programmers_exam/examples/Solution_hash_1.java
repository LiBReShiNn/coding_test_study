package programmers_exam.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_hash_1 {

    public int solution_1(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                // collectingAndThen!!!! 만들고 나서 다음작업을 뭔가 하고 싶을 때.
                // 매개변수: 이 메소드는 아래 나열된 두 개의 매개변수를 허용합니다 .
                // - 다운스트림: 수집기의 인스턴스입니다. 즉, 여기에서 모든 수집기 캔을 사용할 수 있습니다.
                // - Finisher: 다운스트림 컬렉터의 최종 결과에 적용되는 함수의 인스턴스입니다.
                // 반환값: 다운스트림 수집기의 작업을 수행하는 수집기를 반환하고 피니셔 기능의 도움으로 추가 마무리 단계가 뒤따릅니다.
                // 다음은 collectAndThen () 메서드를 설명하는 예제입니다. 예 1: 변경할 수 없는 목록을 만들려면
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }

    public int solution_2(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums) {
            hs.add(num);
        }

//        if(hs.size()>nums.length/2)
//            return nums.length/2;
//
//        return hs.size();

        // 둘중에 작은거. Number.min(a,b)
        return Math.min(hs.size(), nums.length / 2);

    }

    public int solution_3(int[] nums) {
        //1. 기존 length를 구한다.
        //2. 중복값을 제거한 length를 구한다.
        //3. 두 값중 최소값이 정답.
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }

//        nums.length/2 > list.size()?list.size():nums.length/2;
        return Math.min(nums.length / 2, list.size());
    }

}

