// Singleton example
class HayStorage {
	private int quantity = 0;
	private HayStorage() {}

	private static final HayStorage instance = new HayStorage();

	public static HayStorage getInstance() {
		return instance;
	}

	public synchronized void addHay(int amount) {
		this.quantity += amount;
	}

	public synchronized boolean removeHay(int amount) {
		if (quantity < amount) return false;

		quantity -= amount;

		return true;
	}

	public synchronized int getHayQuantity() {
		return this.quantity;
	}
}

// Lazyload singleton
class LazyHayStorage {
	private static volatile LazyHayStorage instance;

	private LazyHayStorage() {}

	public static LazyHayStorage getInstance() {
		if (instance == null) {
			synchronized(LazyHayStorage.class) {
				if (instance == null) {
					instance = new LazyHayStorage();
				}
			}
		}

		return instance;
	}
}

public class Singleton {
	public static void main(String[] args) {
		HayStorage hayStorageManager = HayStorage.getInstance();

		LazyHayStorage lhs = LazyHayStorage.getInstance();
	}
}