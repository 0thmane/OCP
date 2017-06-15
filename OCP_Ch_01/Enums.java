public enum Enums {
	ONCE(true) {
		public void printName() {
			System.out.println("ONCE");
		}
	}, 

	TWICE(true) {
		public void printName() {
			System.out.println("TWICE");
		}
	};

	private Enums(boolean b) {
		System.out.println("Constructing with boolean");
	}
	
	private Enums(String inStr) {
		System.out.println("Constructing with string");
	}


	public abstract void printName();

	public void printCrap() {
		System.out.println("Some crap");
	}

	public static void main(String[] args) {
		Enums firstCall = Enums.ONCE;
		Enums secondCall = Enums.TWICE;

		firstCall.ONCE.printCrap();
	}
}