package com.mercury.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
	
	
	
	
	public static void main(String args[]) {
		
//		Given an array of numbers, write a function to return an array of numbers��
//				products, where products[i] is the product of all nums[j], j != i.
//				Input : [1, 2, 3, 4, 5]
//				Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)] = [120, 60, 40,
//				30, 24]
		
		String s="anagram";
		String t="nagaram";
        
		
		System.out.println(StreamAPI.isAnagram(s, t));
		
		
		
	}
	
	private static boolean isAnagram(String s, String t) {
        List<Character> list=new ArrayList<>();
        
        //if(s.length()!=t.length()) return false;
        
        
        //put all char into a list
        for(int i=0;i<s.length();i++) {
            list.add(s.charAt(i));
        }
        
        // check the char of t and remove from same char from list
        for(int j=0;j<t.length();j++) {
           
           if(list.contains(t.charAt(j))) {
        	   //System.out.println(t.charAt(j));
               list.remove(new Character(t.charAt(j)));
           } else {
        	   System.out.println(t.charAt(j));
           }
           
        }
        
        return list.isEmpty();
    }
	
	
	

}
