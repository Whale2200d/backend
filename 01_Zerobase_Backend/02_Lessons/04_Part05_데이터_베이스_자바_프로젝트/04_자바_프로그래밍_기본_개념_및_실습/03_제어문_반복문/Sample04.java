public class Sample04 {
    public void test() {
        int curMonth = 4;
        int curDay = 0;

        switch (curMonth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                curDay = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                curDay = 30;
                break;
            
            default:
                curDay = 28;
        }
    }
}
