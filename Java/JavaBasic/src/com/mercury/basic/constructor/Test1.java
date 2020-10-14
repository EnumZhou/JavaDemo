package com.mercury.basic.constructor;

public class Test1 {
	
	
	public static class Par{
		//constructor is object level function
		//will be used to initialize all fields right after the object is created
		//can only be called once
		//can be overloaded, only 1 of them will be called only once for each object
		public Par(){
			System.out.println(" Creating Par");
			foo();
		}
		
		public Par(int x){
			System.out.println("Creating Par: "+x);
		}
		
		//non-static method can created in the static class
		public void foo(){
			System.out.println("Par foo!");
		}
		
		public static void bar(){
			
		}
	}
	
	public static class Sub extends Par{
		public Sub(){
			//super constructor can only be called as the very 1st line in the sub constructor
			//this : this object
			//super: parent part of the object
			super();
			System.out.println(" Creating Sub ");
			foo();
		}
		
		@Override
		public void foo(){
			System.out.println("Sub foo!");
		}
	}
	
	public static class A{
		int id;
		String name;
		char gender;
		
		
		
		public A() {
			super();
			// TODO Auto-generated constructor stub
		}



		public A(int id, String name, char gender) {
			super();
			this.id = id;
			this.name = name;
			this.gender = gender;
		}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public char getGender() {
			return gender;
		}



		public void setGender(char gender) {
			this.gender = gender;
		}
		
		
		
		
	}

	public static void main(String[] args) {
		Par p=new Sub();
		//Par.bar();
		//Par p=new Par();
		//p.foo();
	}

}
