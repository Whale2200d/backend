package Test_9;

import java.util.Arrays;

public class Solution3 {
    static class DSU {
        int[] parent, size;
        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }
        void union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return;
            // union by size
            if (size[a] < size[b]) {
                parent[a] = b;
                size[b] += size[a];
            } else {
                parent[b] = a;
                size[a] += size[b];
            }
        }
    }

    /**
     * graph: NxN 인접 행렬 (무향)
     * infected: 처음에 감염된 노드 리스트
     * 한 명을 치료(리스트에서 제거)했을 때
     * 최종 감염자를 최소로 만드는 노드 인덱스를 반환합니다.
     * 동률 시 더 작은 인덱스를 택합니다.
     */
    public static int minMalwareSpread(int[][] graph, int[] infected) {
        int n = graph.length;
        DSU dsu = new DSU(n);

        // 1) 같은 컴포넌트(연결된 영역)로 묶기
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (graph[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }

        // 2) 컴포넌트별 전체 크기 집계
        int[] compSize = new int[n];
        for (int i = 0; i < n; i++) {
            compSize[dsu.find(i)]++;
        }

        // 3) 컴포넌트별 감염자 수 집계
        int[] infectedCount = new int[n];
        for (int u : infected) {
            infectedCount[dsu.find(u)]++;
        }

        // 4) 각 감염자 u를 치료했을 때 막을 수 있는 추가 전파(=컴포넌트 크기) 계산
        //    컴포넌트에 유일한 감염자(u)인 경우에만 의미가 있다.
        int bestNode = Integer.MAX_VALUE;
        int bestSaved = -1;
        for (int u : infected) {
            int root = dsu.find(u);
            if (infectedCount[root] == 1) {
                // 이 컴포넌트는 u만 감염됐으므로, u를 치료하면
                // compSize[root] 명을 감염에서 보호할 수 있다.
                int saved = compSize[root];
                if (saved > bestSaved || (saved == bestSaved && u < bestNode)) {
                    bestSaved = saved;
                    bestNode = u;
                }
            }
        }

        // 5) 유일 감염자 후보가 없으면, 리스트에서 가장 작은 인덱스를 반환
        if (bestSaved == -1) {
            bestNode = Arrays.stream(infected).min().getAsInt();
        }

        return bestNode;
    }

    // 간단 테스트
    public static void main(String[] args) {
        int[][] graph = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        int[] infected = {0,2};
        System.out.println(minMalwareSpread(graph, infected));
        // 예시: 0번 치료가 최적 → 출력 0
    }
}
