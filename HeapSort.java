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
		for (int i = inputArray.length; i > 0;) {
			swap(inputArray, 0, i-1);
			i--;
			downheap(inputArray, 0, i);
		}
	}

	// Public since we are going to check its output!
	public void heapify(K[] inputArray) {
		for (int i = inputArray.length; i >= 0; i--) {
			downheap(inputArray, i, inputArray.length);
		}
	}

	// The below methods are given given as suggestion. You do not need to use them.
	// Feel free to add more methods

	protected void downheap(K[] inputArray, int i, int endInd) {
		if ((i * 2 + 1) > endInd - 1)
			return;
		int childInd;
		if ((i * 2 + 2) > endInd - 1)
			childInd = i * 2 + 1;
		else
			childInd = compare(inputArray[i * 2 + 1], inputArray[i * 2 + 2]) < 0 ? ((i * 2) + 2) : ((i * 2) + 1);
		K self = inputArray[i];

		int comp = compare(self, inputArray[childInd]);
		if (comp > 0)
			return;
		swap(inputArray, i, childInd);
		downheap(inputArray, childInd, endInd);
	}
}
