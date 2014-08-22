package sandbox.lockc.algos.sorting;

import java.util.Arrays;

/**
 * An example implementation of a selection sort algorithm.
 * 
 * @see Algorithms Unlocked by Thomas H. Corman. Page 32, Chapter 3.
 * 
 * @author lockc
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		
		int[] numbers = new int[] {
				2, 9, 88, 3, 3, 4, 7, 1, 5, 6, 7, 7, 8, 9, 10, 3
		};
		
		System.out.println(Arrays.toString(selectionSort(numbers)));
		
	}

	public static int[] selectionSort(int[] numbers) {
		
		for(int i = 0; i < numbers.length - 1; i++) {
			
			// find the smallest number in the sub array [i..length - 1]
			int smallest = smallest(numbers, i);
			
			// swap the smallest number in the array element i
			int temp = numbers[i];
			numbers[i] = numbers[smallest];
			numbers[smallest] = temp;
			
		}
		
		return numbers;
	}
	
	
	
	private static int smallest(int[] numbers, int from) {
		int smallest = from;
		int last = numbers[from];
		
		for(int i = from + 1; i < numbers.length; i++) {
			if(numbers[i] < last) {
				smallest = i;
				last = numbers[smallest];
			}
		}
		return smallest;
	}
}
