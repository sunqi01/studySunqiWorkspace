package com.dbic.keywordtest;

public class StaticTest {

	//类里面的，方法外面的是 成员变量
	//成员变量又分实例变量（没static修饰的） 和 静态变量（有static修饰的）
	
	String shiLiBianLiang = "实例变量";
	static String jingTaiBianLiang = "静态变量";
	
	public void say() {
		System.out.println(shiLiBianLiang);
		System.out.println(jingTaiBianLiang);
	}
	
	
}


class test{
	
	public static void main(String[] args)
	throws Exception{
		//静态变量
		System.out.println(StaticTest.jingTaiBianLiang);
		
		
	}
}
