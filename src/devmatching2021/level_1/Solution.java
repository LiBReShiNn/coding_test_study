package devmatching2021.level_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {

        List<Integer> listWins = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int unknown = Arrays.stream(lottos).map(l -> l == 0 ? 1 : 0).sum();

        if (unknown != 0) {
            int curruntFit = Arrays.stream(lottos).filter(l -> l != 0).map(l -> {
                if (listWins.contains(l)) return 1;
                return 0;
            }).sum();
            return new int[]{7 - (unknown + curruntFit), 7 - (curruntFit == 0 ? 1 : curruntFit)};
        } else {
            int curruntFit = Arrays.stream(lottos).filter(l -> l != 0).map(l -> {
                if (listWins.contains(l)) return 1;
                return 0;
            }).sum();
            return new int[]{7 - (curruntFit == 0 ? 1 : curruntFit), 7 - (curruntFit == 0 ? 1 : curruntFit)};
        }

    }

}
