public class OverloadingTest {
    public static void main(String[] args) {
        CalculatedSum calculate = new CalculatedSum();
        System.out.println((calculate.plus(10, 20)));
        System.out.println(calculate.plus(10, 20, 30));
        System.out.println(calculate.plus(new int[]{10, 20, 30, 40, 50}, 5));
    }
}
