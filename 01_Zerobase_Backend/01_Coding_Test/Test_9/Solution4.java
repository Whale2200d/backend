package Test_9;

import java.util.Arrays;

public class Solution4 {
    public static int solution(int[] x, int[] y) {
        int n = x.length;
        boolean[] used = new boolean[n];
        // dist[i] = 현재 MST에 연결된 점들 중 하나와 i를 잇는 최소 맨해튼 거리
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // MST 시작: 0번 점 선택
        dist[0] = 0;
        int totalCost = 0;

        for (int it = 0; it < n; it++) {
            // MST에 아직 포함되지 않은 점 중 dist가 최소인 u 선택
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!used[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }

            // u를 MST에 추가
            used[u] = true;
            totalCost += dist[u]; // 첫 번째 i=0 때 dist[0]=0 이라 합에 영향 없음

            // u를 새로 추가했으니, 나머지 v에 대해 dist[v] 갱신
            for (int v = 0; v < n; v++) {
                if (!used[v]) {
                    int d = Math.abs(x[u] - x[v]) + Math.abs(y[v] - y[u]);
                    if (d < dist[v]) {
                        dist[v] = d;
                    }
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] x = {0, 0, 3, 3, 6};
        int[] y = {0, 3, 1, 4, 3};
        System.out.println(solution(x,y)); // 14
    }
}
