package com.dbic.impltest;

public class ImplA implements InterfaceTest{

	public void test()
	{
		System.out.println("ImplA=====");
	}
	
	public InterfaceTest get() {
		return new ImplA();
	}
}
