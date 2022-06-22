package com.dbic.collectiontest.listtest;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ListTest {
	//ArrayList<E> extends AbstractList<E> implements List<E>
	//继承了AbstractList  实现了List接口
	ArrayList<String> arrayList = new ArrayList<>();
	public void main(String[] args)
	throws Exception{
		arrayList.add("s");
	}
	
}
