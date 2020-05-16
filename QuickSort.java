package code;

import given.AbstractArraySort;

/*
 * Implement the quick-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class QuickSort<K extends Comparable<K>> extends AbstractArraySort<K> {
	// Add any fields here

	public QuickSort() {
		name = "Quicksort";

		// Initialize anything else here
	}

	// useful if we want to return a pair of indices from the partition function.
	// You do not need to use this if you are just returning and integer from the
	// partition
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

	// Public since we are going to check its output!

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

//	public indexPair partition(K[] inputArray, int lo, int hi, int p) {
////		swap(inputArray, 0, p);
//		int piv = lo, next = 1;
//		for (int i = lo + 1; i < hi; i++) {
//			if (compare(inputArray[piv], inputArray[piv + next]) > 0) {
//				swap(inputArray, piv, piv + next);
//				piv++;
//			} else if (compare(inputArray[piv], inputArray[piv + next]) < 0) {
//				swap(inputArray, piv + next, i);
//				if (compare(inputArray[piv], inputArray[piv + next]) > 0) {
//					swap(inputArray, piv, piv + next);
//					piv++;
//				}
//			} else
//				next++;
//		}
//		indexPair pair = new indexPair(piv - 1, piv + 1);
//		return pair;
//	}

	/*
	 * Alternative, if you are just returning an integer public int partition(K[]
	 * inputArray, int lo, int hi, int p) { //TODO:: Implement a partitioning
	 * function here return null; }
	 */

	// The below methods are given given as suggestion. You do not need to use them.
	// Feel free to add more methods
	protected int pickPivot(K[] inpuArray, int lo, int hi) {
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
