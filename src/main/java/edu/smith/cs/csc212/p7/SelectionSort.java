package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
	public static void selectionSort(List<Integer> unsorted) {
		List<Integer> sorted = new ArrayList<>();
		
		while (unsorted.size()!=0) {
			int min = 0;
			int size = unsorted.size();
			
			for(int i=0; i<size; i++) {
				if(unsorted.get(i)<unsorted.get(min)) {
					min = i;
				}
			}
			int value = unsorted.get(min);
			sorted.add(value);
			unsorted.remove(unsorted.get(min));
		}
	}
}
