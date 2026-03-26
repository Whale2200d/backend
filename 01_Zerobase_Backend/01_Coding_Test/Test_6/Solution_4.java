import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_4 {
    public static int[] solution(int[] arr, int k) {
        if (arr == null || k <= 0 || arr.length < k) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices outside the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // Remove smaller values in deque so that back holds only potential maxima
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            // Starting from i = k-1, record max for each window
            if (i >= k - 1) {
                result[i - k + 1] = arr[dq.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 4, 2, 3};
        int k = 3;
        int[] output = solution(arr, k);
        System.out.println(Arrays.toString(output));
    }
}
