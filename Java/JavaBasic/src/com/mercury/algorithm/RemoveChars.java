package com.mercury.algorithm;
import java. util. Scanner;

public class RemoveChars {
	
	public String remove(String s, char[] target) {
		String newString=s;
		for(int i=0;i<target.length;i++) {
			int index= newString.indexOf(target[i]);
			newString=newString.substring(0,index).concat(newString.substring(index+1, newString.length()));
			//System.out.println(newString);
		}
		
		return newString;
	}
	
	
	public static void main (String args[]) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String: ");
		String s=sc.nextLine();
		
		RemoveChars rm=new RemoveChars();
		char [] target={'s','e'};
		String newStr=rm.remove(s,target);
		
		System.out.println("New String after remving target characters: " + newStr);
		
	}

}
