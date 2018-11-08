package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class MergeSortDoubly {
	public static void addAll(DoublyLinkedList<Integer> fromList, DoublyLinkedList<Integer> toList) {
		while(! fromList.isEmpty()) {
			toList.addBack(fromList.getFront());
			fromList.removeFront();
		}
	}
	
	public static DoublyLinkedList<Integer> mergeSortedLists(DoublyLinkedList<Integer> unsorted1, DoublyLinkedList<Integer> unsorted2) {
		DoublyLinkedList<Integer> sorted = new DoublyLinkedList();
		
//		int size1 = unsorted1.size();
//		int size2 = unsorted2.size();
		
		while(! unsorted1.isEmpty() && ! unsorted2.isEmpty()) {
			if(unsorted1.getIndex(0)<=unsorted2.getIndex(0)) {
				sorted.addBack(unsorted1.getIndex(0));
				unsorted1.removeIndex(0);
			} else {
				sorted.addBack(unsorted2.getIndex(0));
				unsorted2.removeIndex(0);
			}
		}
		
		if(! unsorted1.isEmpty()) {
			addAll(unsorted1, sorted);
		} 
		
		if(! unsorted2.isEmpty()) {
			addAll(unsorted2, sorted);
		}
			
		return sorted;
	}
	
	// do the merging of two lists mergedoblysortedlists
	public static DoublyLinkedList<Integer> mergeDoublySortedLists(DoublyLinkedList<Integer> unsorted1, DoublyLinkedList<Integer> unsorted2) {
		DoublyLinkedList<Integer> sorted = new DoublyLinkedList<>();
		
		while(! unsorted1.isEmpty() && ! unsorted2.isEmpty()) {
			if(unsorted1.getIndex(0)<=unsorted2.getIndex(0)) {
				sorted.addBack(unsorted1.getIndex(0));
				unsorted1.removeIndex(0);
			} else {
				sorted.addBack(unsorted2.getIndex(0));
				unsorted2.removeIndex(0);
			}
		}
		
		if(! unsorted1.isEmpty()) {
			addAll(unsorted1, sorted);
		} 
		
		if(! unsorted2.isEmpty()) {
			addAll(unsorted2, sorted);
		}
			
		return sorted;
	}
	
	// iterative merge sort
	public static DoublyLinkedList<Integer> mergeSortDoublyIterative(DoublyLinkedList<Integer> unsorted){
		// make a new big list
		DoublyLinkedList<DoublyLinkedList<Integer>> bigList = new DoublyLinkedList();
		
		// go through items in unsorted lists and make them their own lists
		for(int i=0;i<unsorted.size();i++) {
			DoublyLinkedList<Integer> smallList = new DoublyLinkedList();
			
			Integer item = unsorted.getIndex(i);
			
			smallList.addBack(item);
			
			// add the small lists to the big lists
			bigList.addBack(smallList);
		}
		
		// while there is more than one list left in the big list
		while(bigList.size()>1) {
			// save the first two small lists 
			DoublyLinkedList<Integer> part1 = bigList.getIndex(0);
			DoublyLinkedList<Integer> part2 = bigList.getIndex(1);
			
			// merge the two small lists 
			DoublyLinkedList<Integer> mergedList = mergeSortedLists(part1, part2);
			
			// add to back of list 
			bigList.addBack(mergedList);
			
			// remove from the front 
			bigList.removeIndex(0);
			bigList.removeIndex(0);
		}
		
		// since everything is merged and sorted, we only have on item in big list
		// so return this one item
		return bigList.getIndex(0);
	}
}