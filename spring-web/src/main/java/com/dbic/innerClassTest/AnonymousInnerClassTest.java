package com.dbic.innerClassTest;

public class AnonymousInnerClassTest {

	public static void main(String[] args)
	throws Exception{
		new AnonymousImpl() {
			
			@Override
			public void say() {
				System.out.println("1111");
				
			}
		};
	}
	
}
