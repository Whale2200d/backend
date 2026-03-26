import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution5 {
    private static final int[][] DIRS = {
            {-1, 0},
            { 1, 0},
            { 0,-1},
            { 0, 1}
    };

    public static int solution(int N, int M, int[][] maze) {
        // 시작, 도착이 막혀있으면 불가
        if (maze[0][0] == 1 || maze[N-1][M-1] == 1) {
            return -1;
        }

        int[][] dist = new int[N][M];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }
        Deque<int[]> q = new ArrayDeque<>();

        // BFS 시작
        dist[0][0] = 0;
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == N-1 && c == M-1) {
                return dist[r][c];
            }

            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (maze[nr][nc] == 1) continue;
                if (dist[nr][nc] != -1) continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 6, M = 6;
        int[][] maze = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0},
                {1, 1, 1, 0, 0, 0}
        };
        // 이제 solution(N, M, maze) 형식으로 호출합니다.
        System.out.println(solution(N, M, maze)); // 16
    }
}
