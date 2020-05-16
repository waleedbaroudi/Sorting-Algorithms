package code;

import java.util.Arrays;

import given.AbstractArraySort;

/*
 * Implement the c algorithm here. You can look at the slides for the pseudo-codes.
 * You do not have to use swap or compare from the AbstractArraySort here
 * 
 * You may need to cast any K to Integer
 * 
 */

public class CountingSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	// Add any fields here

	public CountingSort() {
		name = "Countingsort";
	}

	@Override
	public void sort(K[] inputArray) {

		if (inputArray == null) {
			System.out.println("Null array");
			return;
		}
		if (inputArray.length < 1) {
			System.out.println("Empty array");
			return;
		}

		if (!(inputArray[0] instanceof Integer)) {
			System.out.println("Can only sort integers!");
			return;
		}

		Integer min = findMin((Integer[]) inputArray);
		Integer max = findMax((Integer[]) inputArray);
		Integer counts[] = new Integer[max - min + 1];
		Arrays.fill(counts, 0);
		for (int i = 0; i < inputArray.length; i++) {
			counts[((Integer) inputArray[i]) - min]++;
		}

		for (Integer i = 0, c = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				inputArray[c] = (K) Integer.valueOf(min + i);
				c += 1;
			}
		}

		// TODO:: Implement the counting-sort algorithm here
	}

	public Integer findMin(Integer[] ar) {
		Integer min = ar[0];
		for (int i = 1; i < ar.length; i++)
			if (ar[i] < min)
				min = ar[i];
		return min;
	}

	public Integer findMax(Integer[] ar) {
		int max = ar[0];
		for (int i = 1; i < ar.length; i++)
			if (ar[i] > max)
				max = ar[i];
		return max;
	}
}
