package Test_9;

import java.util.Arrays;

public class Solution2 {
    private static final int INF = Integer.MAX_VALUE / 2;

    /**
     * N개 도시(0 ~ N-1), flights[i] = {u, v, cost},
     * src 에서 dst 로 최대 k번 경유(= 최대 k+1편 비행) 내에 도달하는
     * 최저 비용을 반환합니다. 불가능하면 -1 리턴
     */
    public static int solution(int N, int[][] flights, int src, int dst, int K) {
        // prev[i] = src에서 i까지 현재 허용된 최대 경유 횟수로 도달할 수 있는 최저비용
        int[] prev = new int[N];
        Arrays.fill(prev, INF);
        prev[src] = 0;

        // k번 경유하므로, 총 k+1번 비행기를 탈 수 있다 -> Bellman-Ford를 k+1회 반복
        for (int stops = 0; stops <= K; stops++) {
            int[] curr = prev.clone();
            // 모든 간선을 한 번씩 완화(relax)
            for (int[] f : flights) {
                int u = f[0], v = f[1], cost = f[2];
                if (prev[u] + cost < curr[v]) {
                    curr[v] = prev[u] + cost;
                }
            }
            prev = curr;
        }

        return prev[dst] >= INF ? -1 : prev[dst];
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] flights = {
                {0, 2, 1},
                {1, 3, 20},
                {1, 0, 8},
                {2, 3, 1},
                {0, 3, 3}
        };
        int a = 1, b = 3, k = 2;
        System.out.println(solution(N, flights, a, b, k)); // 11
    }
}
