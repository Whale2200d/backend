import java.util.Arrays;

public class Solution2 {
    public static int[] solution(int n) {
        int[] result = new int[n];
        int curr = 1;

        for (int i = 0; i < n; i++) {
            result[i] = curr;

            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                if (curr % 10 == 9 || curr + 1 > n) {
                    while ((curr % 10 == 9) || (curr + 1 > n)) {
                        curr /= 10;
                    }
                }
                curr++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        int[] result = solution(n);
        System.out.println(Arrays.toString(result));
    }
}
