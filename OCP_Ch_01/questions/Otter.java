public interface Otter {
	default void play() {}
}

class RiverOtter implements Otter {
	/*
		Recall from OCA, methods in interfaces are, by default, public, 
		so overriding methods must be at least as visible, or in this case, public.
	@Override
	void play();
	*/
	@Override
	public void play() {}

	/*
		Compiler error
			- hashCode is inherited from Object and has signature:
				public int hashCode() {//returnSomeInt}
			- Therefore this metthod incorrectly overrides the inherited method
	@Override
	public long hashCode() {
		return 42;
	*/
}