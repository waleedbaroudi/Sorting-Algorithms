package code;

import given.AbstractArraySort;

public class InsertionSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	public InsertionSort() {
		name = "Insertionsort";
	}

	@Override
	public void sort(K[] inputArray) {
		for (int i = 1; i < inputArray.length; i++) {
			int j = i;
			while (compare(inputArray[j], inputArray[j - 1]) < 0) {
				swap(inputArray, j, j - 1);
				j--;
				if (j == 0)
					break;
			}
		}
	}
}
