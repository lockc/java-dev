package sandbox.lockc.algos.searching;

public class LinearSearch {

	public static void main(String[] args) {
		
		int[] numbers = new int[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		};
		
		System.out.println(linearSearch(numbers, 5));
	}

	public static int linearSearch(int[] numbers, int x) {
		
		int n = numbers.length - 1;
		
		for(int i = 0; i < n; i++) {
			if(numbers[i] == x) {
				return i;
			}
		}
		return -1;
	}
}
