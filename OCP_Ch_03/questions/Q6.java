public class Q6 {
	public static void main(String[] args) {
		System.out.println(new Hello<String>("hi"));

		// Compiler warning for using generics and not specifying
		System.out.println(new Hello("there"));	
	}
}

class Hello<T> {
	T t;

	public Hello(T t) {
		this.t = t;
	}

	public String toString() {
		return t.toString();
	}
}