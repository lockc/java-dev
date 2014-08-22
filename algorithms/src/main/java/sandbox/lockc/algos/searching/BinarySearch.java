package sandbox.lockc.algos.searching;

import java.util.Arrays;

/**
 * Binary search only works if the array is already sorted.
 * 
 * @author lockc
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		
		int[] numbers = new int[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		};
		
		System.out.println(binarySearch(numbers, 10));
		
	}
	
	
	public static int binarySearch(int[] numbers, int x) {
		
		int p = 0, r = numbers.length - 1, q = -1;
		
		while(p <= r) {
			
			q = (p + r) / 2;
			
			int number = numbers[q];
			
			// For illustration only
			int[] sub = Arrays.copyOfRange(numbers, p, r + 1);
			System.out.println(String.format("p=%d, q=%s, r=%d", p, q, r));
			
			
			if(number == x) {
				return number;
			} else if (number > x) {
				r = q - 1;
			} else {
				p = q + 1;
			}
			
		}
		
		return -1;
	}
	
	
	
	
}
