/*
	TODO:
		1. Method: getRandomEnum
			- Input : Any Enum
			- Output : Random Enum value
*/

import java.util.Random;

public class EnumController {

	private Random random = new Random();

	private EnumController() {}

	public static void getRandomEnum(Enum<?> someEnum) {
		System.out.println(someEnum);
	}

}