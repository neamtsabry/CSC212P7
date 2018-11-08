package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
	public static List<Integer> insertSorted(List<Integer> sorted, int current) {
		List<Integer> newSorted = null;
		for (int i = 0; i < sorted.size(); i++) {
			if (current < sorted.get(i)) {
				sorted.add(i, current);
				newSorted = sorted;
				break;
			}
		}
		if (newSorted == null) {
			sorted.add(current);
			newSorted = sorted;
		}
		return sorted;
	}

	public static List<Integer> insertionSort(List<Integer> unsorted) {
		List<Integer> sorted = new ArrayList<>();
		sorted.add(unsorted.get(0));
		unsorted.remove(unsorted.get(0));

		while (unsorted.isEmpty() == false) {
			int current = unsorted.get(0);
			unsorted.remove(unsorted.get(0));
			sorted = insertSorted(sorted, current);

		}
		return sorted;
	}
}
