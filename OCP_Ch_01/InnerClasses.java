import java.util.Random;

public class InnerClasses {

	public static void main(String[] args) {
		System.out.println("Running InnerClasses...\n");
		
		/* ============================================== */
		// Playing with Vault

		Vault vault = new Vault();

		Object secretClass = vault.getSecretClass("hi");

		secretClass = vault.getSecretClass("12Ab");

		System.out.println("Secret class: " + secretClass);
		System.out.println("Secret class hash: " + secretClass.hashCode());

		Object sc = vault.getSecretClass("hi");

		/* ============================================== */
		// Playing with Rand

		Rand rand = new Rand();
		Rand.A a = rand.new A();

		a.getInts();
	}
}

class Vault {
	private static int loginCounter = 0;

	public SecretClass getSecretClass(String password) {
		if (AccessValidator.validateAccess(password) & loginCounter < 3) {
			System.out.println("\nAccess Granted.\n");

			SecretClass sc = new SecretClass();
			return sc;
		} else {
			System.out.println("\nAccess Denied. Invalid attempts: " + loginCounter + "\n");

			loginCounter++;

			return null;
		}
	}

	/* Static nested class */
	public static class AccessValidator {
		private AccessValidator() {}

		public static boolean validateAccess(String inStr) {
			boolean result = false;

			if (inStr.equals("12Ab")) result = true;

			return result;
		}
	}

	/* Member inner class */
	private class SecretClass implements Secret {
		@Override
		public String toString() {
			return "Secret Class #####";
		}

		@Override
		public int hashCode() {
			return super.hashCode();
		}
	}

	private interface Secret {}
}

class Rand {
	private int a = 0;

	public class A {
		private int a = 1;

		public void getInts() {
			System.out.println(Rand.this.a);
			System.out.println(this.a);
		}

		public void methodClass() {

			/* Inner Class */
			class MethodClass{}
		}
	}
}