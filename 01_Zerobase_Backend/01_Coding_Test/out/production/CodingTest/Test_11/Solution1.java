public class Solution1 {
    private static final int MOD = 10004;

    public static int solution(int n, int num) {
        String curr = String.valueOf(num);

        for (int i = 0; i < n; i++) {
            int[] cnt = new int[10];

            for (char c : curr.toCharArray()) {
                cnt[c - '0']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int d = 0; d <= 9; d++) {
                if (cnt[d] > 0) {
                    sb.append(d).append(cnt[d]);
                }
            }

            curr = sb.toString();
        }

        int rem = 0;
        for (char c : curr.toCharArray()) {
            rem = (rem * 10 + (c - '0')) % MOD;
        }
        return rem;
    }

    public static void main(String[] args) {
        int n = 3;
        int num = 54223;
        System.out.println(solution(n, num));
    }
}
