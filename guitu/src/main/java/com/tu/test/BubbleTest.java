package com.tu.test;
/**
 * 二分法查找
 *
 */
public class BubbleTest {
	public static void main(String[] args) {
		int [] arrs = {1,2,3,4,5,6,7,8};
		System.out.println(BubbleTest.sort(arrs, 5));
	}
	
	public static int sort(int [] arrs,int value) {
		int low = 0;
		int high = arrs.length - 1;
		
		while (low <= high) {
			int middle = (low + high) / 2;
			if (arrs[middle] == value) {
				return middle;
			}
			
			if (arrs[middle] > value) {
				high = middle - 1;
			}
			
			if (arrs[middle] < value) {
				low = middle + 1;
			}
		}
		
		return -1;
	}
}
