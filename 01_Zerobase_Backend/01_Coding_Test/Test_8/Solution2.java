package Test_8;

public class Solution2 {
    /**
     * blocks[d][j] 에너지로 블록을 제거할 때,
     * 0행 아무 칸에서 시작하여 인접(대각, 수직) 이동만으로
     * depth행 n열까지 도달하는 최소 에너지 합을 반환한다.
     */
    public static int minEnergy(int depth, int n, int[][] blocks) {
        int m = blocks[0].length;
        // prev[j] = 깊이 d-1에서 j열까지의 최소 누적 에너지
        int[] prev = new int[m];
        // 깊이 0행 초기화
        for (int j = 0; j < m; j++) {
            prev[j] = blocks[0][j];
        }

        // curr 행 계산용
        int[] curr = new int[m];

        // 깊이 1부터 depth까지 차례로 DP
        for (int d = 1; d <= depth; d++) {
            for (int j = 0; j < m; j++) {
                // prev[j-1], prev[j], prev[j+1] 중 최소값
                int best = prev[j];
                if (j > 0) best = Math.min(best, prev[j-1]);
                if (j < m-1) best = Math.min(best, prev[j+1]);
                curr[j] = best + blocks[d][j];
            }
            // curr -> prev로 교체
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
        }

        // 목표 depth, n열까지의 최소 에너지
        return prev[n];
    }
}
