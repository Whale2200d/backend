package Test_9;

import java.util.*;

public class Solution5 {
    private static class Edge {
        int node, time;
        Edge(int n, int t) {
            node = n;
            time = t;
        }
    }

    public static int solution(int N, int[][] relations) {
        // 1. 문제 간 relations 정보를 양방향 map으로 저장
        Map<Integer, List<Edge>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] r : relations) {
            int u = r[0], v = r[1], t = r[2];
            adj.get(u).add(new Edge(v, t));
            adj.get(v).add(new Edge(u, t));
        }
        // 각 이웃 리스트는 시간 오름차순으로 정렬해 두면 편리
        for (List<Edge> list : adj.values()) {
            list.sort(Comparator.comparingInt(e -> e.time));
        }

        // 2. 방문하지 않은 문제 집합
        Set<Integer> unvisited = new HashSet<>();
        for (int i = 0; i < N; i++) {
            unvisited.add(i);
        }

        // 3. 그리디 시작점: 최대 degree(관계 수)인 문제 중 가장 작은 인덱스
        int start = 0;
        int maxDeg = -1;
        for (int i = 0; i < N; i++) {
            int deg = adj.get(i).size();
            if (deg > maxDeg || (deg == maxDeg && i < start)) {
                maxDeg = deg;
                start = i;
            }
        }

        int time = 30;
        int cur = start;
        unvisited.remove(cur);

        // 4. 남은 문제들이 없을 때까지
        while (!unvisited.isEmpty()) {
            int next = -1, cost = 30;
            // 현재 문제(cur)의 인접 리스트에서
            // 아직 공부하지 않은 문제 중 최소 시간인 하나를 찾는다.
            for (Edge e : adj.get(cur)) {
                if (unvisited.contains(e.node)) {
                    next = e.node;
                    cost = e.time;
                    break;
                }
            }

            // 인접 관계가 하나도 없으면, unvisited에서 아무거나 꺼내서 30분
            if (next == -1) {
                next = unvisited.iterator().next();
                cost = 30;
            }

            // 5. 문제 공부
            time += cost;
            unvisited.remove(next);
            cur = next;
        }

        return time;
    }

    public static void main(String[] args) {
        int N = 6;
        int[][] relations = {
                {2, 3, 15},
                {1, 5, 10},
                {3, 4, 25},
                {1, 2, 27},
                {1, 4, 29},
                {2, 5, 5}
        };
        System.out.println(solution(N, relations));
    }
}
