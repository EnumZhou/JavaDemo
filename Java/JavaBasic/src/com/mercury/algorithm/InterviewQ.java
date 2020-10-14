package com.mercury.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterviewQ {
	
	
	public static void main (String args[]) {
		
		List<Integer> arrival=new ArrayList<> (Arrays.asList(1,3,3,5,7));
		List<Integer> duration = new ArrayList <> (Arrays.asList(2,2,1,2,1));
		List<Integer> end=new ArrayList<> ();
		
		for (int i=0; i<arrival.size();i++) {
			System.out.println(arrival.get(i)+duration.get (i));
			end.add(arrival.get(i)+duration.get (i));
			
		}
		
		
		
	}
	
	
}
