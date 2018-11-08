package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class MergeSortIterative {
	public static List<Integer> mergeSortIterative(List<Integer> unsorted){
		// make a new big list
		List<List<Integer>> bigList = new ArrayList<>();
		
		// go through items in unsorted lists and make them their own lists
		for(Integer item : unsorted) {
			List<Integer> smallList = new ArrayList<>();
			smallList.add(item);
			
			// add the small lists to the big lists
			bigList.add(smallList);
		}
		
		// while there is more than one list left in the big list
		while(bigList.size()>1) {
			// save the first two small lists 
			List<Integer> part1 = bigList.get(0);
			List<Integer> part2 = bigList.get(1);
			
			// merge the two small lists 
			List<Integer> mergedList = MergeSortedLists.mergeSortedLists(part1, part2);
			
			// add to back of list 
			bigList.add(mergedList);
			
			// remove from the front 
			bigList.remove(part1);
			bigList.remove(part2);
		}
		
		// since everything is merged and sorted, we only have on item in big list
		// so return this one item
		return bigList.get(0);
	}
}
