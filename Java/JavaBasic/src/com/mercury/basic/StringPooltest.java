package com.mercury.basic;

public class StringPooltest {

	public static void main(String[] args) {
		String s1="xy";
		String s2="xy";
		String s3=new String("xy");
		String s4=new String("xy");
		
		System.out.println(s1==s2);//true
		System.out.println(s2==s3);//false
		System.out.println(s3==s4);//false
		
		
		String s5=new String("abc");
		String s6=new String("abc");
		
		System.out.println(s5.intern()== s6.intern());//true
		
		//Builder: create object piece by piece -not thread-safe-performance good (vs StringBuffer)
		StringBuilder sb=new StringBuilder();
		sb.append("bbbb");
		
		//String buffer is thread safe, so performance bad-slow
		StringBuffer sbf=new StringBuffer();
		
		
		
		
	}

}
