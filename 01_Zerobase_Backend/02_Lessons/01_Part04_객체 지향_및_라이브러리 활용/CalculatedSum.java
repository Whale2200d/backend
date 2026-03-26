public class CalculatedSum {
	public int plus(int value1, int value2) {
		return value1 + value2;
	}
	
	public long plus(int value1, int value2, int value3) {
		return value1 + value2 + value3;
	}
	
	public int plus(int[] value, int valueCount) {
		int sum = 0;
		for (int i = 0; i < valueCount; i++) {
			sum += value[i];
		}
		return sum;
	}
}
