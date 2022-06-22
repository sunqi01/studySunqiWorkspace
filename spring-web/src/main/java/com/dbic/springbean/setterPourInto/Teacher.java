package com.dbic.springbean.setterPourInto;

public class Teacher {

	private String name = "";
	private String age = "";
	private Profession profession;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	
	public void say()
	{
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		System.out.println("professionId:"+profession.getProfessionId());
		System.out.println("professionName:"+profession.getProfessionName());
	}
	
	
}
