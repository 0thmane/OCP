/* 
	Reflection:
		- Lower performance than typical operations because some compiler operations are not 
			possible
		- Could potentially not run in environemnts with reduced runtime permissions
		- Can access private paremeters
*/

import java.util.Random;

public class EnumController {

	private static Random random = new Random();

	private EnumController() {}

	// Using reflection
	public static <T extends Enum<T>> T getRandomEnum(Class<T> someEnumClass) {
		T[] enumConstants = someEnumClass.getEnumConstants();
		int enumQuantity = enumConstants.length;
		int randomInt = random.nextInt(enumQuantity);

		return enumConstants[randomInt];
	}

}