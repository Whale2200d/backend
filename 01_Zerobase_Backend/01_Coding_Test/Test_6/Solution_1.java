public class Solution_1 {
    public int[] solution(int[] values) {
        if (values == null || values.length == 0) {
            return new int[]{0, 0};
        }

        int start = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int maxLength = 0;

        for (int i = 1; i < values.length; i++) {
            if (values[i - 1] < values[i]) {
                // 증가
                if (i - start > maxLength) {
                    maxLength = i - start;
                    maxStart = start;
                    maxEnd = i;
                }
            } else {
                // 증가가 끊김
                start = i;
            }
        }

        if (maxLength == 0) {
            return new int[]{0, 0};
        }

        return new int[]{maxStart, maxEnd};
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] values = {103, 152, 124, 165, 152, 154, 159, 160, 200, 195, 205, 206, 204, 189, 156};
        int[] result = solution.solution(values);
        System.out.println("{" + result[0] + "," + result[1] + "}");
    }
}
