package code;

import given.AbstractArraySort;

public class QuickSort<K extends Comparable<K>> extends AbstractArraySort<K> {
	// Add any fields here

	public QuickSort() {
		name = "Quicksort";
	}
	
	public class indexPair {
		public int p1, p2;

		indexPair(int pos1, int pos2) {
			p1 = pos1;
			p2 = pos2;
		}

		public String toString() {
			return "(" + Integer.toString(p1) + ", " + Integer.toString(p2) + ")";
		}
	}

	@Override
	public void sort(K[] inputArray) {
		int lo = 0, hi = inputArray.length - 1;
		quickSort(inputArray, lo, hi);
	}

	public void quickSort(K[] arr, int lo, int hi) {
		if (lo < hi) {
			indexPair pair = partition(arr, lo, hi, lo);
			quickSort(arr, lo, pair.p1);
			quickSort(arr, pair.p2, hi);
		}

	}


	public indexPair partition(K[] inputArray, int lo, int hi, int p) {
		// two-way partitioning

		indexPair pair;
		swap(inputArray, p, hi);
		K pivot = inputArray[hi];
		int l = lo, h = hi - 1;
		while (l <= h) {
			while ((l <= h) && (compare(inputArray[l], pivot) <= 0)) {
				l++;
			}
			while ((l <= h) && (compare(inputArray[h], pivot) > 0)) {
				h--;
			}

			if (l <= h) {
				swap(inputArray, l, h);
				l++;
				h--;
			}
		}
		swap(inputArray, l, hi);
		pair = new indexPair(l - 1, l + 1);
		return pair;
	}


	protected int pickPivot(K[] inpuArray, int lo, int hi) { // optional use: it picks the median of first, last, and middle (to lower the chance of worst case occuring).
		K maxK = max(inpuArray[(lo + hi) / 2], max(inpuArray[lo], inpuArray[hi]));
		int median = 0;
		if (maxK == inpuArray[lo])
			median = max(inpuArray[hi], inpuArray[(lo + hi) / 2]) == inpuArray[(lo + hi) / 2] ? ((lo + hi) / 2) : hi;
		if (maxK == inpuArray[hi])
			median = max(inpuArray[lo], inpuArray[(lo + hi) / 2]) == inpuArray[(lo + hi) / 2] ? ((lo + hi) / 2) : lo;
		if (maxK == inpuArray[(lo + hi) / 2])
			median = max(inpuArray[hi], inpuArray[lo]) == inpuArray[lo] ? lo : hi;
		return median;
	}

	private K max(K k1, K k2) {
		return compare(k1, k2) > 0 ? k1 : k2;
	}
}
