package code;

import given.AbstractArraySort;

/*
 * Implement the merge-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 * You may need to create an Array of K (Hint: the auxiliary array). 
 * Look at the previous assignments on how we did this!
 * 
 */

public class MergeSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	// Add any fields here

	public MergeSort() {
		name = "Mergesort";

		// Initialize anything else here
	}

	@Override
	public void sort(K[] inputArray) {
		mergeSort(inputArray, 0, inputArray.length - 1);
	}

	public void mergeSort(K[] arr, int lo, int hi) {
		if (lo < hi) {
			int mid = lo / 2 + hi / 2;
			mergeSort(arr, lo, mid);
			mergeSort(arr, mid + 1, hi);
			merge(arr, lo, mid, hi);
		}
	}

	// Public since we are going to check its output!
	public void merge(K[] inputArray, int lo, int mid, int hi) {
		K auxArray[] = (K[]) new Comparable[inputArray.length];
		rangeCopy(inputArray, auxArray, lo, hi);
		int firstInd = lo, mergedInd = lo, secondInd = mid + 1;
		while (mergedInd <= hi) {
			if ((secondInd > hi) || ((firstInd <= mid) && (auxArray[firstInd].compareTo(auxArray[secondInd]) <= 0))) {
				inputArray[mergedInd] = auxArray[firstInd];
				firstInd++;
				mergedInd++;
			} else {
				inputArray[mergedInd] = auxArray[secondInd];
				secondInd++;
				mergedInd++;
			}
		}
	}

	public void rangeCopy(K[] from, K[] to, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			to[i] = from[i];
		}
	}

	// Feel free to add more methods
}
