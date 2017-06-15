import java.util.Random;

public class InnerClasses {

	public static void main(String[] args) {
		System.out.println("Running InnerClasses...\n");
		
		Vault vault = new Vault();

		Object secretClass = vault.getSecretClass("hi");

		secretClass = vault.getSecretClass("12Ab");

		System.out.println("Secret class: " + secretClass);
		System.out.println("Secret class hash: " + secretClass.hashCode());

		Object sc = vault.getSecretClass("hi");
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

	public static class AccessValidator {
		private AccessValidator() {}

		public static boolean validateAccess(String inStr) {
			boolean result = false;

			if (inStr.equals("12Ab")) result = true;

			return result;
		}
	}

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