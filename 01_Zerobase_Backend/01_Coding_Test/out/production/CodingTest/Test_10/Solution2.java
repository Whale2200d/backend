public class Solution2 {
    /**
     * num의 각 자릿수를 한 번 교환해서 얻을 수 있는 최대값 반환
     * @param num
     * @return
     */
    public static int maximumSwap(int num) {
        char[] A = String.valueOf(num).toCharArray();
        int n = A.length;
        // last[d] = A 배열에서 숫자 d ('0' ~ '9')가 마지막으로 등장하는 인덱스
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[A[i] - '0'] = i;
        }

        // 왼쪽부터 순회하며, 큰 숫자로 교환 가능한지 확인
        for (int i = 0; i < n; i++) {
            int cur = A[i] - '0';
            // '9'부터 cur+1까지 내려오며, 더 큰 숫자가 뒤에 있으면 교환
            for (int d = 9; d > cur; d--) {
                if (last[d] > i) {
                    // swap A[i] <-> A[last[d]]
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    // 한 번만 교환 가능하므로 바로 결과 반환
                    return Integer.parseInt(new String(A));
                }
            }
        }

        // 교환할 필요 없으므로 원래 수 반환
        return num;
    }
    public static void main(String[] args) {
        int num = 43824;
        System.out.println(maximumSwap(num));
    }
}
