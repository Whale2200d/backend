package Test_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution5 {
    public static int[][] solution(int[][] buildings) {
        List<int[]> points = new ArrayList<>();

        // 1. 시작점은 -height, 끝점은 +height로 표현
        for (int[] b : buildings) {
            points.add(new int[]{b[0], -b[2]});
            points.add(new int[]{b[1], b[2]});
        }

        // 2. x좌표 기준 정렬, 높이는 낮은 것부터 먼저 처리
        points.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1]; // 시작점(-height) 먼저 처리
        });

        // 3. 최대 높이 저장을 위한 우선순위 큐 (max heap)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0); // 지면 (높이 0)

        List<int[]> result = new ArrayList<>();
        int prevMax = 0;

        for (int[] p : points) {
            int x = p[0], h = p[1];

            if (h < 0) {
                maxHeap.add(-h);
            } else {
                maxHeap.remove(h);
            }

            int currMax = maxHeap.peek();
            if (currMax != prevMax) {
                result.add(new int[]{x, currMax});
                prevMax = currMax;
            }
        }

        return result.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int[][] buildings = {
            {1, 8, 4},
            {2, 4, 10},
            {3, 5, 6},
            {10, 12, 6}
        };

        int[][] output = solution(buildings);
        for (int[] point : output) {
            System.out.println(Arrays.toString(point));
        }
        // 기대 출력: {{1, 4}, {2, 10}, {4, 6}, {5, 4}, {8, 0}, {10, 6}, {12, 0}}
    }
}
