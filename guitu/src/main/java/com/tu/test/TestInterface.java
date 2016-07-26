package com.tu.test;

public interface TestInterface {
	void introduce();
	
	default void haveRest() {
		System.out.println("I'm tired, let me have a rest!");
	}
	
	
}


