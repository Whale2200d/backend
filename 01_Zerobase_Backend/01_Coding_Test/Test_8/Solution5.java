package Test_8;

public class Solution5 {
    /**
     * N개의 물건, 첫째 가방 용량 K1, 둘째 가방 용량 K2,
     * 물건 i의 무개 W[i], 가치 V[i]가 주어질 때,
     * 두 가방에 담을 수 있는 최대 가치 합을 반환
     *
     * 시간 복잡도 0, 공간 복잡도 0이다.
     */
    public static int maxTotalValue(int N, int K1, int K2, int[] W, int[] V) {
        // dp[w1][w2] = 첫 i개 아이템을 고려했을 때
        // 첫째 가방에 w1, 둘째 가방에 w2 용량을 사용하여 얻을 수 있는 최대 가치
        int[][] dp = new int[K1 + 1][K2 + 1];

        for (int i = 0; i < N; i++) {
            int wi = W[i], vi = V[i];
            // i번째 아이템을 넣을 때는 뒤에서부터 순회해야 덮어쓰지 않는다.
            for (int w1 = K1; w1 >= 0; w1--) {
                for (int w2 = K2; w2 >= 0; w2--) {
                    int best = dp[w1][w2]; // 아이템을 안 넣는 경우
                    if (w1 >= wi) {
                        best = Math.max(best, dp[w1 - wi][w2] + vi);
                    }
                    if (w2 >= wi) {
                        best = Math.max(best, dp[w1][w2 - wi] + vi);
                    }
                    dp[w1][w2] = best;
                }
            }
        }

        return dp[K1][K2];
    }

    public static void main(String[] args) {
        int N = 8;
        int K1 = 10, K2 = 15;
        int[] W = {6, 4, 5, 6, 8, 9, 10, 3};
        int[] V = {10, 4, 6, 8, 2, 8, 5, 6};

        int answer = maxTotalValue(N, K1, K2, W, V);
        System.out.println(answer);  // 출력: 34
    }
}
