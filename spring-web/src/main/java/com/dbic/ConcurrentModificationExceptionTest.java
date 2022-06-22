package com.dbic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExceptionTest {

	public static void main(String[] args) {
		try {
			List<String> list = new ArrayList<String>();
			list.add("a");
			list.add("b");
			list.add("c");
			
//			for(String s:list) {
//				if("b".equals(s)) {
//					list.remove(s);
//				}
//			}
			
//			Iterator<String> it = list.iterator();
//			while(it.hasNext()) {
//				String s = it.next();
//				if("b".equals(s)) {
//					list.remove(s);
////					it.remove();
//				}
//			}
			Iterator<String> it = list.iterator();
			for(String s:list) {
				String ss = it.next();
				if("a".equals(ss)) {
					list.remove(ss);
				}
			}
			
			
			for(String ss:list) {
				System.out.println(ss);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
