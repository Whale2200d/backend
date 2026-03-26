package Test_7;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution5 {
    /**
     * nums 배열에서 연속 부분 배열의 (합 * 최소값) 점수 중 최대값을 반환
     */
    public static int maxScore(int[] nums) {
        int n = nums.length;

        // 1. prefix sum 준비
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // 2. 이전에 더 작은 값이 있는 인덱스 (left boundary)
        int[] left = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // 3. 이후에 더 작은 값이 있는 인덱스 (right boundary)
        int[] right = new int[n];
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // 4. 각 i를 최소값으로 쓰는 구간 [lef[i]+1 .. right[i]-1]의 합 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = prefix[right[i]] - prefix[left[i]+1];
            int score = sum * nums[i];
            if (score > answer) {
                answer = score;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 10, 9, 8, 5};
        System.out.println(maxScore(nums)); // 216
    }
}
