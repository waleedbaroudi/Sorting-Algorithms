package code;

import given.AbstractArraySort;

/*
 * Implement the heap-sort algorithm here. You can look at the slides for the pseudo-code.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class HeapSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	// Add any fields here

	public HeapSort() {
		name = "Heapsort";

		// Initialize anything else here
	}

	@Override
	public void sort(K[] inputArray) {
		heapify(inputArray);
		for (int i = inputArray.length - 1; i > 0;) {
			swap(inputArray, 0, i);
			i--;
			downheap(inputArray, 0, i);
		}
	}

	// Public since we are going to check its output!
	public void heapify(K[] inputArray) {
		for (int i = inputArray.length / 2; i >= 0; i--) {
			downheap(inputArray, i, inputArray.length - 1);
		}
	}

	// The below methods are given given as suggestion. You do not need to use them.
	// Feel free to add more methods

	protected void downheap(K[] inputArray, int i, int endInd) {
		int current = i, left = 2 * i + 1, right = 2 * i + 2;
		if (left <= endInd)
			if (compare(inputArray[current], inputArray[left]) < 0)
				current = left;
		if (right <= endInd)
			if (compare(inputArray[current], inputArray[right]) < 0)
				current = right;
		if (current != i) {
			swap(inputArray, current, i);
			downheap(inputArray, current, endInd);
		}
	}
}
