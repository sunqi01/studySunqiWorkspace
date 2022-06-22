package com.dbic.innerClassTest;

public class StaticInnerClassTest {

	
	private String a = "a";
	private static String b = "b";
	//静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。
	//静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，
	//并且它不能使用外部类的非static成员变量或者方法，这点很好理解，因为在没有外部类的对象的情况下，可以创建静态内部类的对象，
	//如果允许访问外部类的非static成员就会产生矛盾，因为外部类的非static成员必须依附于具体的对象。
	
	static class staticInner{
		public void say() {
//			System.out.println(a);
			System.out.println(b);
		}
	}
}
