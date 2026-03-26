import java.util.Arrays;

public class Solution_5 {
    public static int[] solution(int[] scores) {
        int n = scores.length;
        if (n == 0) return new int[0];
        int[] chocolates = new int[n];
        Arrays.fill(chocolates, 1);

        for (int i = 1; i < n; i++) {
            if (scores[i] > scores[i - 1]) {
                chocolates[i] = chocolates[i - 1] + 1;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (scores[i] > scores[i+1]) {
                chocolates[i] = Math.max(chocolates[i], chocolates[i+1] + 1);
            }
        }

        return chocolates;
    }

    public static void main(String[] args) {
        int[] scores = {1, 3, 5, 4, 5, 5, 5, 1};
        int[] result = solution(scores);
        System.out.println(Arrays.toString(result));
    }
}
