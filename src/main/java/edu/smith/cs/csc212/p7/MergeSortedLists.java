package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {
	// two lists as input 
	
	//  we take first two items 
	
	// 
	
	public static List<Integer> mergeSortedLists(List<Integer> unsorted1, List<Integer> unsorted2) {
		List<Integer> sorted = new ArrayList<>();
		
//		int size1 = unsorted1.size();
//		int size2 = unsorted2.size();
		
		while(! unsorted1.isEmpty() && ! unsorted2.isEmpty()) {
			if(unsorted1.get(0)<=unsorted2.get(0)) {
				sorted.add(unsorted1.get(0));
				unsorted1.remove(0);
			} else {
				sorted.add(unsorted2.get(0));
				unsorted2.remove(0);
			}
		}
		
		if(! unsorted1.isEmpty()) {
			sorted.addAll(unsorted1);
		} 
		
		if(! unsorted2.isEmpty()) {
			sorted.addAll(unsorted2);
		}
			
		return sorted;
	}
}
