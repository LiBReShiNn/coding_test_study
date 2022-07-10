package devmatching2021.level_1;

public class Solution_3 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int cnt1 = 0;
        int cnt2 = 0;
        for (int i : lottos) {
            if (i == 0) {
                cnt1++;
                continue;
            }
            for (int j : win_nums) {
                if (i == j) cnt2++;
            }
        }


        answer[0] = getGrade(cnt1 + cnt2);
        answer[1] = getGrade(cnt2);

        return answer;
    }

    public int getGrade(int n) {
        switch (n) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
