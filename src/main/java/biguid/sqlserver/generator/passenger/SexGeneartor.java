package biguid.sqlserver.generator.passenger;

import java.util.Random;

import biguid.sqlserver.generator.Generator;

public class SexGeneartor extends Generator {
	private static Random random = new Random(System.currentTimeMillis());

	@Override
	public String get() {
		boolean isMale = random.nextBoolean();
		if (isMale) {
			return "Male";
		} else {
			return "Female";
		}
	}

}
