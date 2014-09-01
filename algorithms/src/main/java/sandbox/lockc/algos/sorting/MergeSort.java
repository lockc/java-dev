
package sandbox.lockc.algos.sorting;

import java.util.Arrays;

/**
 * An example implementation of an merge sort algorithm.
 * 
 * @see Algorithms Unlocked by Thomas H. Corman. Page 40, Chapter 3.
 * 
 * @author lockc
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		
		int[] numbers = new int[] {
				9, 2, 88, 3, 3, 4, 7, 1, 5, 6, 7, 7, 8, 9, 10, 3
		};
		
		System.out.println(Arrays.toString(mergeSort(numbers, 0, numbers.length - 1)));
		
		System.out.println();
	}

	public static int[] mergeSort(int[] numbers, int p, int r) {
		
		if(p >= r) {
			return numbers;
		}
		
		int q = (p + r) / 2;
		
		System.out.println(String.format("{p=%d, q=%d, r=%d}",  p, q, r));
		
		mergeSort(numbers, p, q);
		mergeSort(numbers, q + 1 , r);
		
		
		
		merge(numbers, p, q, r);
		
		return numbers;
	}
	
	public static void merge(int[] numbers, int p, int q, int r) {
		
		System.out.println(String.format("Merge {p=%d, q=%d, r=%d}",  p, q, r));
		
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int[] sub1 = new int[n1 + 1];
		int[] sub2 = new int[n2 + 1];
		
		for(int x = p; x <= q; x++) {
			sub1[x] = numbers[x];
		}
		
		for(int x = q + 1; x <= r; x++) {
			sub2[x - 1] = numbers[x];
		}
		
		sub1[n1 + 1] = -999;
		sub2[n1 + 1] = -999;
		
		int i = 1, j = 1;
		
		for(int k = p; k < r; k++) {
			
		}
		
		
	}
	
	
}
