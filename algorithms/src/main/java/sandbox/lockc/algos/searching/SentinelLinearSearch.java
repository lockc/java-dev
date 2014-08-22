package sandbox.lockc.algos.searching;

public class SentinelLinearSearch {

	public static void main(String[] args) {
		
		int[] numbers = new int[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		};
		
		System.out.println(sentinelLinearSearch(numbers, 5));
	}
	
	public static int sentinelLinearSearch(int[] numbers, int x) {
		
		int n = numbers.length - 1;
		int last = numbers[n];
		
		// Replace the last.  e.g. the sentinel
		numbers[n] = x;
		
		// loop until we find a value equally x
		int i = 0;
		while (numbers[i] != x) {
			i++;
		}
		
		// replace the last element with it original value
		numbers[n] = last;
		
		// now check
		if(i < n || numbers[n] == x) {
			return i;
		}
		return -1;
	}
}
