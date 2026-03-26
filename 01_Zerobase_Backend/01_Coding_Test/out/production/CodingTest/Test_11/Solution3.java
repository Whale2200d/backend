public class Solution3 {
    public static boolean solution(String s, String[] words) {
        int n = s.length();

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;

            for (String w : words) {
                int len = w.length();
                int end = i + len;

                if (end <= n && !dp[end] && s.startsWith(w, i)) {
                    dp[end] = true;
                    if (end == n) return true;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "zerobase";
        String[] words = {"zer", "ro", "ze", "base"};
        System.out.println(solution(s, words));
    }
}
