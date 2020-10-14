//print out 10 (pass by value) 02/05/2020

/*Primitive type passed by value (byte, short,char, int, float,long, double, boolean*/
public class PassByValue {
	static void foo(int y){
		y=5;
	}
	
	public static void main(String [] args){
		int x=10;
		PassByValue.foo(x);
		System.out.println(x);
	}
}
