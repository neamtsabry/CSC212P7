package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class MergeSortRecursive {
	
	public static List<Integer> mergeSortRecursive (List<Integer> unsorted){
		// if the list has more than one item
		if(unsorted.size()>1) {
			// divide in half 
			int mid = unsorted.size()/2;
			List<Integer> first = 
					new ArrayList<>(unsorted.subList(0, mid));
			List<Integer> second = 
					new ArrayList<>(unsorted.subList(mid, unsorted.size()));
			
			// merge sort each half 
			List<Integer> merged1 = mergeSortRecursive(first);
			List<Integer> merged2 = mergeSortRecursive(second);
			
			// merge the two sorted halves into a list and return that list
			List<Integer> merged = MergeSortedLists.mergeSortedLists(merged1, merged2);
			
			return merged;
		}
		return unsorted;
	}
}
