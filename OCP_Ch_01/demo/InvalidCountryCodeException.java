class InvalidCountryCodeException extends Exception {
	
	public InvalidCountryCodeException() {}

	public InvalidCountryCodeException(String comment) {
		super(comment);
	}
}