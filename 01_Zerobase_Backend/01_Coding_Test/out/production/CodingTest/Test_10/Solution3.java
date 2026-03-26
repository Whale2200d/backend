import java.util.*;

public class Solution3 {
    /**
     * N개의 노드(0..N-1), root=0.
     * leftPairs[k] = {parent, leftChild}, rightPairs[l] = {parent, rightChild}.
     * '거꾸로 BFS' 순회를 노드 인덱스 배열로 반환합니다.
     */
    public static int[] reverseBFS(int N, int[][] leftPairs, int[][] rightPairs) {
        // 1) 자식 배열 초기화
        int[] leftChild  = new int[N];
        int[] rightChild = new int[N];
        Arrays.fill(leftChild, -1);
        Arrays.fill(rightChild, -1);
        for (int[] p : leftPairs) {
            leftChild[p[0]] = p[1];
        }
        for (int[] p : rightPairs) {
            rightChild[p[0]] = p[1];
        }

        // 2) BFS로 깊이 계산 & 레벨별 노드 수집
        int[] depth = new int[N];
        Arrays.fill(depth, -1);
        List<List<Integer>> levels = new ArrayList<>();

        Queue<Integer> q = new ArrayDeque<>();
        depth[0] = 0;
        q.offer(0);

        while (!q.isEmpty()) {
            int u = q.poll();
            int d = depth[u];
            if (levels.size() <= d) {
                levels.add(new ArrayList<>());
            }
            levels.get(d).add(u);

            // 왼쪽 자식 → 오른쪽 자식 순서로 enqueue
            if (leftChild[u]  != -1) { depth[leftChild[u]]  = d + 1; q.offer(leftChild[u]);  }
            if (rightChild[u] != -1) { depth[rightChild[u]] = d + 1; q.offer(rightChild[u]); }
        }

        // 3) 거꾸로 BFS: 깊은 레벨→얕은 레벨, 레벨 내 오→왼
        List<Integer> order = new ArrayList<>(N);
        for (int level = levels.size() - 1; level >= 0; level--) {
            List<Integer> nodes = levels.get(level);
            for (int i = nodes.size() - 1; i >= 0; i--) {
                order.add(nodes.get(i));
            }
        }

        // 4) List<Integer> → int[]
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 6;
        int[][] left  = {{0,1},{1,5},{2,3}};
        int[][] right = {{0,2},{3,4}};
        System.out.println(Arrays.toString(reverseBFS(N, left, right)));
        // 출력 예시: [5, 2, 4, 3, 1, 0]
    }
}
