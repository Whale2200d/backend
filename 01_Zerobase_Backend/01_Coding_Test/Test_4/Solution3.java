package Test_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public static String[][] solution(String[] words, String[] queries) {
        String[][] result = new String[queries.length][];

        for (int q = 0; q < queries.length; q++) {
            String query = queries[q];
            List<String> matched = new ArrayList<>();

            for (String word : words) {
                if (word.length() != query.length()) continue;

                boolean match = true;
                for (int i = 0; i < query.length(); i++) {
                    char qc = query.charAt(i);
                    if (qc == '?') continue;
                    if (word.charAt(i) != qc) {
                        match = false;
                        break;
                    }
                }

                if (match) matched.add(word);
            }

            result[q] = matched.toArray(new String[0]);
        }

        return result;
    }
    public static void main(String[] args) {
        String[] words = {"hello", "hear", "hell", "good", "goose", "children", "card", "teachable"};
        String[] queries = {"he??", "g???", "childre?", "goo????", "?"};

        String[][] result = solution(words, queries);

        for (String[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
