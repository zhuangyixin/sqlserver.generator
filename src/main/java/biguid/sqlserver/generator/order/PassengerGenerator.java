package biguid.sqlserver.generator.order;

import java.util.Random;

public class PassengerGenerator {
	private static Random indexRandom = new Random(System.currentTimeMillis());

	public long get() {
		int passengerIndex = indexRandom.nextInt(40602);
		return (long) passengerIndex;
	}
}
