//Print out 5 pass by reference 02/05/2020

/*  Object passed by reference  */
public class PassByReference {
	static void foo(User x) {
		x.age = 5;
	}

	public static void main(String[] args) {
		User u = new User();
		u.age = 10;
		foo(u);
		u.age=8;
		System.out.println(u.age);
	}

}

class User {
	int age;
}
