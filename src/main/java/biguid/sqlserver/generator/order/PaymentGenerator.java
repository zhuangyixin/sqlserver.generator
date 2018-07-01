package biguid.sqlserver.generator.order;

import java.util.Random;

public class PaymentGenerator {
	private static Random random = new Random(System.currentTimeMillis());

	public String getCVV() {
		String cvv = String.format("%03d", random.nextInt(1000));
		return cvv;
	}

	public String getCardNumber() {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < 4; i++) {
			String number = String.format("%04d", random.nextInt(10000));
			buffer.append(number);
		}
		return buffer.toString();
	}
}
