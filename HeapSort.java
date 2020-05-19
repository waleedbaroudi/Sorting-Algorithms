package code;

import given.AbstractArraySort;


public class HeapSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	public HeapSort() {
		name = "Heapsort";
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

	public void heapify(K[] inputArray) {
		for (int i = inputArray.length / 2; i >= 0; i--) {
			downheap(inputArray, i, inputArray.length - 1);
		}
	}


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
