package Test_8;

public class Solution4 {
    private static final int MOD = 1007;

    /**
     * maze[r][c] = 0(빈 방), 1(잠긴 방), 2(열쇠 방)
     * start = (0, 0), exit = (n-1, m-1)
     * 오른쪽 또는 아래로만 이동하며 반드시 열쇠 칸을 거쳐야 할 때
     * 가능한 경로 수 mod 1007을 반환
     */
    public static int countPaths(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;

        // 열쇠 위치 찾기
        int keyR = -1, keyC = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 2) {
                    keyR = i;
                    keyC = j;
                }
            }
        }

        // 1. (0, 0) -> (keyR, keyC)까지 경로의 수
        int[][] dp1 = new int[n][m];
        if (maze[0][0] != 1) dp1[0][0] = 1;
        for (int i = 0; i <= keyR; i++) {
            for (int j = 0; j <= keyC; j++) {
                if (maze[i][j] == 1 || (i==0 && j==0)) continue;
                int ways = 0;
                if (i > 0) ways += dp1[i-1][j];
                if (j > 0) ways += dp1[i][j-1];
                dp1[i][j] = ways % MOD;
            }
        }

        // 2. (keyR, keyC) -> (n-1, m-1)까지 경로의 수
        int[][] dp2 = new int[n][m];
        dp2[keyR][keyC] = dp1[keyR][keyC]; // 여기에 도달하는 각각의 경로가 그대로 이어짐
        for (int i = keyR; i < n; i++) {
            for (int j = keyC; j < m; j++) {
                if ((i == keyR && j == keyC) || maze[i][j] == 1) continue;
                int ways = 0;
                if (i > keyR) ways += dp2[i-1][j];
                if (j > keyC) ways += dp2[i][j-1];
                dp2[i][j] = ways % MOD;
            }
        }

        return dp2[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0},
                {0, 2, 0},
                {1, 0, 0}
        };
        System.out.println(countPaths(maze)); // 2
    }
}
