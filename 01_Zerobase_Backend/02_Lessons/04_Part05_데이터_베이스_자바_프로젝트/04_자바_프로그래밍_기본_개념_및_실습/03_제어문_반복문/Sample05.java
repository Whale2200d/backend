public class Sample05 {
    
    public static void main(String[] args) {
        // 구구단
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %d\t", j, i, i * j);
            }
            System.out.println("");
        }
    }
}
