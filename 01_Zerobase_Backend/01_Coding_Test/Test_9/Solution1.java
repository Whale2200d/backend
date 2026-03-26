package Test_9;

import java.util.*;

public class Solution1 {
    static class Edge {
        int to, w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    /**
     * 0번 친구에게 거짓말을 시작으로
     * friend[i][k]에 time[i][k]만큼 후에
     * 거짓말이 전파될 때, 모든 친구가 거짓말을 믿게 되는 최소 시간.
     * 도달 불가능한 친구가 있으면 -1을 반환
     *
     * @param N (친구 수)
     * @param friend (인접 친구 목록 friend[i])
     * @param time (전파 시간 time[i][k] (friend[i][k]와 짝))
     */
    public static int solution(int N, int[][] friend, int[][] time) {
        // 1. 그래프 인접 리스트로 변환
        List<Edge>[] graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            for (int k = 0; k < friend[i].length; k++) {
                graph[i].add(new Edge(friend[i][k], time[i][k]));
            }
        }

        // 2. Dijkstra 초기화
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // pq 요소: { 현재까지 걸린 시간, 노드 번호 }
        pq.offer(new int[]{0, 0});

        // 3. Dijkstra 수행
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (d > dist[u]) continue;
            for (Edge e : graph[u]) {
                int v = e.to, w = e.w;
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        // 4. 결과 계산: 모든 친구에게 도달했는지, 최대값은?
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (dist[i] == INF) {
                // 도달 불가능한 친구가 있으면
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] friend = {{1, 4}, {2, 3}, {4}, {1}, {0, 2}};
        int[][] time = {{5, 2}, {6, 4}, {9}, {1}, {2, 6}};
        System.out.println(solution(N, friend, time)); // 9
    }
}
