package com.dbic.innerClassTest;

public class MemberInnerClassTest {

	private String name = "MemberInnerClassTest";
	private static String a = "aaa";
	
	class inner{
		private String a = "bbb";
		
		public void say() {
			System.out.println("直接访问外部类的 private成员和static成员");
			System.out.println(name);
			System.out.println(a);
			//当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员。
			//如果要访问外部类的同名成员，需要以下面的形式进行访问：
			System.out.println(MemberInnerClassTest.this.a);
		}
	}
	
	//外部类想访问内部类就不能直接用了
	public void outSay()
	{
		inner inner = new inner();
		inner.say();
	}
	
	public static void main(String[] args)
	throws Exception{
		MemberInnerClassTest memberInnerClassTest = new MemberInnerClassTest();
		memberInnerClassTest.outSay();
	}
}
