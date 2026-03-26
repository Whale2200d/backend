package Test_4;

import java.util.Arrays;

public class Solution1 {
    public static String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        String[][] result = new String[problems.length][];

        for (int p = 0; p < problems.length; p++) {
            String problem = problems[p];
            String[] matched = new String[0];

            for (int i = 0; i < lyrics.length; i++) {
                if (lyrics[i].startsWith(problem)) {
                    matched = Arrays.copyOf(matched, matched.length + 1);
                    matched[matched.length - 1] = titles[i];
                }
            }

            result[p] = matched;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] titles = {"아모르파티", "아기상어", "올챙이와개구리", "산다는건"};
        String[] lyrics = {
            "산다는게다그런거지누구나빈손으로와...(후략)",
            "아기상어뚜루루뚜루귀여운뚜루루뚜루...(후략)",
            "개울가에올챙이한마리꼬물꼬물헤엄치다...(후략)",
            "산다는건다그런거래요힘들고아픈날도많지만...(후략)"
        };
        String[] problems = {"산다", "아기상어", "올챙이"};

        String[][] result = solution(titles, lyrics, problems);

        for (String[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
