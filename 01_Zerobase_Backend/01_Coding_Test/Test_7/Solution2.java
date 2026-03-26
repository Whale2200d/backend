package Test_7;

public class Solution2 {
    // Boyer–Moore Voting Algorithm
    public static int findMajority(int[] votes) {
        int candidate = votes[0];
        int count = 1;

        // 1) 후보 선출 단계
        for (int i = 1; i < votes.length; i++) {
            if (votes[i] == candidate) {
                count++;
            } else if (--count == 0) {
                candidate = votes[i];
                count = 1;
            }
        }

        // (검증 단계는 과반 존재가 보장되므로 생략 가능)
        return candidate;
    }

    public static void main(String[] args) {
        int[] votes1 = {1, 4, 2, 2, 2, 3, 2, 2, 1};
        System.out.println(findMajority(votes1)); // 2

        int[] votes2 = {4, 3, 2, 3, 3, 3, 3, 1, 2, 2, 3};
        System.out.println(findMajority(votes2)); // 3
    }
}
