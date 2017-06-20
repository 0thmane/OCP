public class Outer {
	private int x = 5;

	protected class Inner {
		// Compiler Error: Inner classes cannot have static members, unless it's a static inner class
		// public static int x = 10;
		public int x = 10;
		public void go() {
			System.out.println(x);
		}
	}

	static class StaticInner {
		public static void strRep() {
			System.out.println("In static inner class");
		}
	}

	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();
		in.go();

		// ----------------------------------------------------------

		/* 	Wierd but valid syntax, inner class that aren't static need to 
			be created via an instance of the outer class.
		*/
		Outer.Inner in2 = new Outer().new Inner();

		// ----------------------------------------------------------

		Outer.StaticInner staticInner = new Outer.StaticInner();
		staticInner.strRep();
	}
}