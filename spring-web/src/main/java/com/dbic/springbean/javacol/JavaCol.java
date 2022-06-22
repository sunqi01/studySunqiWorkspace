package com.dbic.springbean.javacol;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaCol {
	private String[] courses;
	private List<String> list;
	private Map<String, String> maps;
	private Set<String> sets;
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, String> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	public Set<String> getSets() {
		return sets;
	}
	public void setSets(Set<String> sets) {
		this.sets = sets;
	}
	
	public void say() {
		System.out.println("courses==="+courses.toString());
		System.out.println("list==="+list.toString());
		System.out.println("maps==="+maps.toString());
		System.out.println("sets==="+sets.toString());
	}
}
