package com.tu.test;

/**
 * ð������
 *
 */
public class SortTest {
	public static void main(String[] args) {
		int [] arrs = {1,23,2,54,4,99,100,3};
		SortTest.sort(arrs);
	}
	
	public static void sort(int [] arrs) {
		System.out.println("=====����ǰ=====");
		for (int i = 0;i < arrs.length; i++) {
			System.out.println(arrs[i]);
		}
		
		for (int i = 0; i < arrs.length; i++) {
			for (int j = i + 1; j < arrs.length; j++) {
				int temp = 0;
				//����λ��
				if (arrs[i] > arrs[j]) {
					temp = arrs[i];
					arrs[i] = arrs[j];
					arrs[j] = temp;
				}
			}
		}
		
		System.out.println("=====�����=====");
		for (int i = 0;i < arrs.length; i++) {
			System.out.println(arrs[i]);
		}
	}
}
