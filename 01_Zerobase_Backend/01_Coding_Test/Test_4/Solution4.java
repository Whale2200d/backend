package Test_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution4 {
    static class Task {
        int start, time, index;

        Task(int start, int time, int index) {
            this.start = start;
            this.time = time;
            this.index = index;
        }
    }

    public static int[] solution(int[] start, int[] time) {
        int n = start.length;

        // 모든 작업을 리스트로 묶고, 시작 시각 순 정렬
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(start[i], time[i], i));
        }
        tasks.sort(Comparator.comparingInt(t -> t.start));

        PriorityQueue<Task> pq = new PriorityQueue<>(
            (a, b) -> a.time == b.time ? a.index - b.index : a.time - b.time
        );

        List<Integer> result = new ArrayList<>();
        int timeNow = 0;
        int i = 0; // task 리스트 포인터

        while (i < n || !pq.isEmpty()) {
            while (i < n && tasks.get(i).start <= timeNow) {
                pq.offer(tasks.get(i));
                i++;
            }

            if (!pq.isEmpty()) {
                Task curr = pq.poll();
                result.add(curr.index);
                timeNow += curr.time;
            } else {
                // 처리할 수 있는 작업이 없다면, 다음 작업까지 시간 점프
                timeNow = tasks.get(i).start;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] start = {0, 2, 3, 5, 6};
        int[] time = {2, 4, 2, 1, 3};

        int[] result = solution(start, time);
        System.out.println(Arrays.toString(result)); // [0, 1, 3, 2, 4]
    }
}
