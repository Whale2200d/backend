import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_2 {
    /**
     * Distribute meats of various values to maximize total eating value.
     *
     * @param amount  array of available portions per meat type
     * @param value   array of unit values per meat type
     * @param stomach array of each friend's capacity
     * @return maximum total value eatable under the fairness constraint
     */
    public int solution(int[] amount, int[] value, int[] stomach) {
        int n = amount.length;
        int m = stomach.length;
        // Copy capacities
        int[] cap = Arrays.copyOf(stomach, m);
        // Sort meat indices by descending unit value
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Integer.compare(value[b], value[a]));

        long total = 0L;

        // 1) Highest-value meat: must distribute equally among ALL friends
        {
            int meat = idx[0];
            int rem = amount[meat];
            int val = value[meat];
            // Compute minimum remaining capacity among all friends
            int minCap = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                minCap = Math.min(minCap, cap[j]);
            }
            // Compute per-person share
            int p = Math.min(rem / m, minCap);
            if (p > 0) {
                long used = (long) p * m;
                total += used * val;
                // Deduct share from each friend
                for (int j = 0; j < m; j++) {
                    cap[j] -= p;
                }
            }
        }

        // 2) Remaining meats: distribute among all friends who still can eat
        for (int i = 1; i < n; i++) {
            int meat = idx[i];
            int rem = amount[meat];
            int val = value[meat];
            while (rem > 0) {
                // Count eaters and find their minimum capacity
                int eaters = 0;
                int minCap = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    if (cap[j] > 0) {
                        eaters++;
                        minCap = Math.min(minCap, cap[j]);
                    }
                }
                // Stop if no one can eat or not enough portions for one each
                if (eaters == 0 || rem < eaters) break;
                // Compute optimal per-person share
                int p = Math.min(rem / eaters, minCap);
                if (p <= 0) break;
                long used = (long) eaters * p;
                total += used * val;
                rem -= used;
                // Deduct share
                for (int j = 0; j < m; j++) {
                    if (cap[j] > 0) {
                        cap[j] -= p;
                    }
                }
            }
        }

        return (int) total;
    }

    public static void main(String[] args) {
        Solution_2 sol = new Solution_2();
        int[] amount = {7, 10, 4, 5};
        int[] value = {5, 4, 3, 1};
        int[] stomach = {4, 6, 2, 8};
        // Expect 74
        System.out.println(sol.solution(amount, value, stomach));
    }
}
