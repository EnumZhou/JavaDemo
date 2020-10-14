package com.mercury.basic.oop;

public class AccessTest2 extends Accessibility{
	
	@Override
	public void f5(){System.out.println("Non-static overridden f5");}
	@Override
	protected void f6(){System.out.println("Non-static overridden f6");}
	@Override
	void f7(){System.out.println("Non-static overridden f7");}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Accessibility.f1();
		Accessibility.f2();
		Accessibility.f3();
		
		AccessTest2 t2=new AccessTest2();
		t2.f5();
		t2.f6();
		t2.f7();
		

	}

}
