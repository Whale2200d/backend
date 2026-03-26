package Test_8;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
    static class Job {
        int start, end, price;
        Job(int s, int e, int p) {
            start = s;
            end = e;
            price = p;
        }
    }

    /**
     * start, end, price 배열로 주어진 상담 요청 중
     * 겹치지 않게 골라서 price 합을 최대로 만들어 반환한다.
     */
    public static int maxConsultationProfit(int[] start, int[] end, int[] price) {
        int n = start.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(start[i], end[i], price[i]);
        }

        // 종료 시간 기준 정렬
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

        // 정렬된 종료 시간만 담은 배열
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            ends[i] = jobs[i].end;
        }

        // dp[i]: 첫 i개의 작업(jobs[0...i-1]) 중 최대 이익
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // i번째 작업은 jobs[i-1]
            Job job = jobs[i-1];

            // jobs[i-1].start 이하로 끝나는 가장 큰 인덱스를 이진 탐색
            int idx = Arrays.binarySearch(ends, job.start);
            if (idx < 0) {
                // not found -> insertion point = -idx-1,
                // 따라서 끝나는 시간이 start보다 작거나 같은 마지막 인덱스 = insertionPoint-1 = -idx-2
                idx = -idx - 2;
            }
            // idx = -1이면 앞서 고를 수 있는 작업이 없음
            int profitWithThis = job.price + (idx >= 0 ? dp[idx+1] : 0);

            // 고르지 않을 때 dp[i-1] vs 고를 때 profitWithThis
            dp[i] = Math.max(dp[i-1], profitWithThis);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] start = {1, 5, 10, 6, 5};
        int[] end = {5, 6, 12, 9, 12};
        int[] price = {10, 40, 30, 20, 50};

        int answer = maxConsultationProfit(start, end, price);
        System.out.println(answer); // 100
    }
}
