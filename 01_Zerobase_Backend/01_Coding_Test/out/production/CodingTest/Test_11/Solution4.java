import java.util.Arrays;

public class Solution4 {
    public static int solution(int money, int[] chips) {
        final int INF = money + 1;
        int[] dp = new int[money + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int c : chips) {
            for (int x = c; x <= money; x++) {
                dp[x] = Math.min(dp[x], dp[x-c]+1);
            }
        }

        return dp[money] == INF ? -1 : dp[money];
    }

    public static void main(String[] args) {
        int money = 3000;
        int[] chips = {1100, 500, 200, 150, 25};
        System.out.println(solution(money, chips));
    }
}
