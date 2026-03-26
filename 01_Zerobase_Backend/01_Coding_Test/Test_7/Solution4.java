package Test_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution4 {
    private static final int MAX_INT = Integer.MAX_VALUE;

    /**
     * nums 문자열을 유사 피보나치 수열로 나눌 수 있으면,
     * 그 수열을 List<Integer>로 반환하고, 그렇지 않으면 빈 리스트를 반환한다.
     */
    public static int[] splitIntoFibonacci(String nums) {
        int n = nums.length();

        for (int i = 1; i <= Math.min(10, n - 2); i++) {
            if (nums.charAt(0) == '0' && i > 1) break;
            long a = Long.parseLong(nums.substring(0, i));
            if (a > MAX_INT) break;

            for (int j = i + 1; j <= Math.min(i + 10, n - 1); j++) {
                if (nums.charAt(i) == '0' && j - i > 1) break;
                long b = Long.parseLong(nums.substring(i, j));
                if (b > MAX_INT) break;

                List<Integer> seq = new ArrayList<>();
                seq.add((int)a);
                seq.add((int)b);

                int pos = j;
                while (pos < n) {
                    long c = seq.get(seq.size() - 2) + seq.get(seq.size() - 1);
                    if (c > MAX_INT) break;
                    String s = String.valueOf(c);
                    if (pos + s.length() > n || !nums.startsWith(s, pos)) {
                        break;
                    }
                    seq.add((int)c);
                    pos += s.length();
                }

                if (pos == n && seq.size() >= 3) {
                    // List<Integer> → int[]
                    int[] res = new int[seq.size()];
                    for (int k = 0; k < seq.size(); k++) {
                        res[k] = seq.get(k);
                    }
                    return res;
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        String input1 = "14152944";
        System.out.println(Arrays.toString(splitIntoFibonacci(input1)));
        // return: {14, 15, 29, 44}

        String input2 = "1101111";
        System.out.println(Arrays.toString(splitIntoFibonacci(input2)));
        // return: {11, 0, 11, 11} 혹은 첫 번째 유효 조합

        String input3 = "123";
        System.out.println(Arrays.toString(splitIntoFibonacci(input3)));
        // return: {} (impossible)
    }
}
