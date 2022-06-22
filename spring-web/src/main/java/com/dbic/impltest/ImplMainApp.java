package com.dbic.impltest;

public class ImplMainApp {

	public static void main(String[] args)
	throws Exception{
		try {
			ImplA implA = new ImplA();
			implA.get().test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
       
        
	}
	
	class Solution {
	    public int romanToInt(String s)
	    throws Exception {

	        String strArr = "IVXLCDM";
	        if(strArr.indexOf(s)<0){
	            throw new  Exception("无效的数字");
	        }
	        
	        return 0;

	    }
	}
}
