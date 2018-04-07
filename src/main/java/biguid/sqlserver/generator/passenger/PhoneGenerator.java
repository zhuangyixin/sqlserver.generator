package biguid.sqlserver.generator.passenger;

import java.util.Random;

import biguid.sqlserver.generator.Generator;

public class PhoneGenerator extends Generator {
	private static Random regionNumberRandom = new Random(System.currentTimeMillis());
	private static Random phoneNumberRandom = new Random(System.currentTimeMillis() + 1000);
	private static Random preffixNumberRandom = new Random(System.currentTimeMillis() + 2000);

	@Override
	public String get() {
		int regionNumber = regionNumberRandom.nextInt(1000);
		int phoneNumber = phoneNumberRandom.nextInt(10000000);
		int index = preffixNumberRandom.nextInt(9);
		String phone = String.format("%d-%s-%08d", regionNumber, this.data.get(index), phoneNumber);
		return phone;
	}

}
