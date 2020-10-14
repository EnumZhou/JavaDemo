package com.mercury.basic;

import com.mercury.basic.oop.Accessibility;

public class AccessTest extends Accessibility {
	
	@Override
	public void f5(){
		
	}
	@Override
	protected void f6(){}
	

	public static void main(String[] args) {
		Accessibility.f1();
		Accessibility.f2();
		AccessTest test=new AccessTest();
		test.f5();
		test.f6();
	}

}
