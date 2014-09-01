
package sandbox.lockc.algos.sorting;

import java.util.Arrays;

/**
 * An example implementation of an insertion sort algorithm.
 * 
 * @see Algorithms Unlocked by Thomas H. Corman. Page 35, Chapter 3.
 * 
 * @author lockc
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		
		int[] numbers = new int[] {
				9, 2, 88, 3, 3, 4, 7, 1, 5, 6, 7, 7, 8, 9, 10, 3
		};
		
		System.out.println(Arrays.toString(insertionSort(numbers)));
		
	}

	public static int[] insertionSort(int[] numbers) {
		
		int n = numbers.length;
		
		for(int i = 1; i < n; i++) {
			
			int key = numbers[i];
			int j = i - 1;
			
			while(j >= 0 && numbers[j] > key) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = key;
			
		}
		
		return numbers;
	}
	
	
}
