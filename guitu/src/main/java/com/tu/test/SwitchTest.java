package com.tu.test;

public class SwitchTest {

	public static void main(String[] args) {
		int num = 2;
		switch (num) {
		default:
			System.out.println("default.....");
			break;
		case 1:
			System.out.println("111111111");
			break;
		case 2:
			System.out.println("222222");
			break;
		}
	}
	
	public static void test(){
		System.out.println("test111");
	}

	public static void test(int num,String name){
		
	}
	
	public static void test(String name,int num) {
		
	}
}
