package com.dbic.springbean.constructPourInto;

public class Student {

	private String name = "";
	private String age = "";
	private Grade grade;
	
	public Student(String name,String age,Grade grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	public void say() {
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		System.out.println("gradeId:"+grade.gradeId);
		System.out.println("gradeName:"+grade.gradeName);
	}
}
