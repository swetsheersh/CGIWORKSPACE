package com.cgi.july_21;

import java.time.LocalDateTime;

public class TC_Wrapper {
	public static void main(String[] args) {
		String str="1234";
		int num=Integer.parseInt(str);
		num+=2;
		System.out.println(num);
		
		int a=5;
		float b=a;
		System.out.println(b);
		
		float c = 55.65f;
		int d=(int)c;
		System.out.println(d);
		
		StringBuffer buffer=new StringBuffer("abc");
		System.out.println(buffer);
		buffer.append("hello");
		System.out.println(buffer);
		
		StringBuilder builder=new StringBuilder("hello");
		builder.reverse().append(str);
		System.out.println(builder);
		
		
		
		
	}
	
}
