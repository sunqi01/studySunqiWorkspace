package com.dbic.innerClassTest;

public class PartInnerClassTest {

	//局部内部类是定义在一个方法或者一个作用域里面的类，
	//它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
	private String b = "b";
	public void dealInner() {
		String a = "a";
		class inner{
			public void say() {
				System.out.println(a);
				System.out.println(b);
			}
		}
		new inner().say();
		
	}
	
	public static void main(String[] args)
	throws Exception{
		PartInnerClassTest partInnerClassTest = new PartInnerClassTest();
		partInnerClassTest.dealInner();
	}
}
