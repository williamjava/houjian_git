package com.tu.test;

public class TestInterfaceImpl implements TestInterface {

	@Override
	public void introduce() {
		System.out.println("Hello, my name is WuHoujian.");
		this.haveRest();
	}

}
