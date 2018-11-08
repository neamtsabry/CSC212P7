package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(List<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.get(i) >= items.get(i+1)) {
				System.err.println("items out of order: "+items.get(i)+", "+items.get(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};
	private static int[] datab = {9,8,7,6,5,4,3,2,1};
	
	/*
	 * Here's some more  data! 
	 * This time they're two sorted lists especially made for 
	 * merge two sorted lists
	 */
	public static int[] data1 = {1,3,5,7,9};
	public static int[] data2 = {2,4,6,8,10};
	
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}

	@Test 
	public void testSelectionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
				
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test 
	public void testInsertionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		
		List<Integer> fixed = InsertionSort.insertionSort(new ArrayList<>(sortMe));
		Assert.assertTrue(checkSorted(fixed));
				
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		List<Integer> fixed2 = InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(fixed2));
	}
	
	@Test 
	public void testMergeTwoLists() {
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int x : data1) {
			sortMe.add(x);
		}
		
		ArrayList<Integer> sortMe2 = new ArrayList<>();
		for (int y : data2) {
			sortMe2.add(y);
		}
		
		List<Integer> fixed = MergeSortedLists.mergeSortedLists(new ArrayList<>(sortMe),
				new ArrayList<>(sortMe2));
		Assert.assertTrue(checkSorted(fixed));
	}
	
	@Test 
	public void testMergeSortRecursive() {
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int x : data) {
			sortMe.add(x);
		}
		
		List<Integer> fixed = MergeSortRecursive.mergeSortRecursive(new ArrayList<>(sortMe));
		Assert.assertTrue(checkSorted(fixed));
	}
	
	@Test 
	public void testMergeSortIterative() {
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int x : data) {
			sortMe.add(x);
		}
		
		List<Integer> fixed = MergeSortIterative.mergeSortIterative(new ArrayList<>(sortMe));
		Assert.assertTrue(checkSorted(fixed));
		System.out.println(fixed);
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		List<Integer> fixed2 = MergeSortIterative.mergeSortIterative(sortMe);
		Assert.assertTrue(checkSorted(fixed2));
		System.out.println(fixed2);
	}
	
	public DoublyLinkedList<Integer> makeFullList() {
		DoublyLinkedList<Integer> data = new DoublyLinkedList<Integer>();
		data.addBack(9);
		data.addBack(8);
		data.addBack(7);
		data.addBack(6);
		return data;
	}
	
	private static boolean checkSorted(DoublyLinkedList<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) >= items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	@Test 
	public void testDoublyMergeSort() {
		DoublyLinkedList<Integer> unsorted = new DoublyLinkedList();
		
		for(Integer item : data) {
			unsorted.addBack(item);
		}
		
		DoublyLinkedList<Integer> fixed = MergeSortDoubly.mergeSortDoublyIterative(unsorted);
		Assert.assertTrue(checkSorted(fixed));
		System.out.println(fixed);
	}
}
