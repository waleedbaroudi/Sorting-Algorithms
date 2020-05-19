package code;

import given.AbstractArraySort;

public class MergeSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	K auxArray[];

	public MergeSort() {
		name = "Mergesort";
	}

	@Override
	public void sort(K[] inputArray) {
		auxArray = (K[]) new Comparable[inputArray.length];
		mergeSort(inputArray, 0, inputArray.length - 1);
	}

	public void mergeSort(K[] arr, int lo, int hi) {
		if (lo < hi) {
			int mid = (hi + lo) / 2;
			mergeSort(arr, lo, mid);
			mergeSort(arr, mid + 1, hi);
			merge(arr, lo, mid, hi);
		}
	}
	public void merge(K[] inputArray, int lo, int mid, int hi) {
		rangeCopy(inputArray, auxArray, lo, hi);
		int firstInd = lo, mergedInd = lo, secondInd = mid + 1;
		while (mergedInd <= hi) {
			if ((secondInd > hi) || ((firstInd <= mid) && (compare(auxArray[firstInd], auxArray[secondInd]) <= 0))) {
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
}
