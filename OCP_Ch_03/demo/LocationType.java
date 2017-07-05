/*
	TODO:
		1. Move getRandomType to a Generic
*/

import java.util.*;

public enum LocationType {
	MERCURY("Mercury"),
	VENUS("Venus"),
	EARTH("Earth"),
	MARS("Mars"),
	JUPITER("Jupiter"),
	SATURN("Saturn"),
	URANUS("Uranus"),
	NEPTUNE("Neptune"),
	PLUTO("Pluto"),
	IN_TRANSIT("In transit"),
	CLASSIFIED("Classified");

	private String location;

	private LocationType(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return this.location;
	}
}