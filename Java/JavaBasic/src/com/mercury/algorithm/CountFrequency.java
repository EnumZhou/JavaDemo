package com.mercury.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountFrequency {
	
	public void count(String s) {
		Map<Character,Integer> hm=new HashMap<Character,Integer>();
		for (int i=0; i<s.length();i++) {
			int count=0;
			char c=s.charAt(i);
			if(hm.containsKey(c)) {
				count=hm.get(c);
			}
			hm.put(c, ++count);
		}
		Set<Map.Entry<Character,Integer>> entries = hm.entrySet();
		for(Map.Entry<Character,Integer> entry: entries) {
			System.out.print("charcter: "+ entry.getKey());
			System.out.println(", Occurance: "+ entry.getValue());
		}
	}
	
	
	public static void main (String args[]) {
		
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter a String: ");
		String s= sc.nextLine();
		CountFrequency cf=new CountFrequency();
		cf.count(s);
	}

}
