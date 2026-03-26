public class Solution1 {
    // 0~9 각 숫자의 5줄 패턴 정의
    private static final String[][] PATTERNS = {
            { "#####", "#---#", "#---#", "#---#", "#####" }, // 0
            { "--#--", "--#--", "--#--", "--#--", "--#--" }, // 1
            { "####",  "---#", "####",  "#---", "####"  }, // 2
            { "####",  "---#", "####",  "---#", "####"  }, // 3
            { "#---#", "#---#", "#####", "----#", "----#" }, // 4
            { "#####", "#----", "#####", "----#", "#####" }, // 5
            { "#####", "#----", "#####", "#---#", "#####" }, // 6
            { "#####", "----#", "----#", "----#", "----#" }, // 7
            { "#####", "#---#", "#####", "#---#", "#####" }, // 8
            { "#####", "#---#", "#####", "----#", "----#" }  // 9
    };

    /**
     * 숫자 n을 받아 전광판 5줄 패턴을 String[5]로 반환
     */
    public static String[] render(int n) {
        String s = String.valueOf(n);
        int length = s.length();
        String[] out = new String[5];

        // 각 행별로 문자열을 쌓는다.
        for (int row = 0; row < 5; row++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <length; i++) {
                int d = s.charAt(i) - '0';
                sb.append(PATTERNS[d][row]);
                if (i < length - 1) sb.append(" ");
            }
            out[row] = sb.toString();
        }
        return out;
    }

    public static void main(String[] args) {
        int n = 857;
        String[] ans = render(n);
        for (String line : ans) {
            System.out.println(line);
        }
    }
}
