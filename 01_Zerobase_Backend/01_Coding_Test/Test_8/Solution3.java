package Test_8;

public class Solution3 {
    /**
     * rewards 배열이 원형으로 배치되었을 때,
     * 인접한 성은 동시에 털 수 없다는 제약 하에
     * 얻을 수 있는 최대 보상을 반환
     */
    public static int maxReward(int[] rewards) {
        int n = rewards.length;
        if (n == 0) return 0;
        if (n == 1) return rewards[0];
        // 1. 첫 성을 털지 않는 경우, [1, ..., n-1]
        int case1 = robLinear(rewards, 1, n-1);
        // 2. 첫 성을 터는 경우: [0, ..., n-2] (마지막 성은 제외)
        int case2 = robLinear(rewards, 0, n-2);
        return Math.max(case1, case2);
    }

    /**
     * 선형 구간 rewards[L..R]에서 인접 털기 금지 조건으로
     * 최대 보상을 구하는 House Robber I DP
     */
    private static int robLinear(int[] rewards, int L, int R) {
        int incl = 0; // 직전 집을 털었을 때의 최대
        int excl = 0; // 직전 집을 털지 않았을 때의 최대

        for (int i = L; i <= R; i++) {
            int newExcl = Math.max(incl, excl);
            incl = excl + rewards[i];
            excl = newExcl;
        }

        // 마지막 집을 털지 않았을 때 vs 털었을 때
        return Math.max(incl, excl);
    }

    // 예제 실행
    public static void main(String[] args) {
        int[] rewards = {5, 10, 5, 7, 5, 9};
        System.out.println(maxReward(rewards)); // 26
    }
}
