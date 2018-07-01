package biguid.sqlserver.generator.order;

import java.text.DecimalFormat;
import java.util.Random;

import biguid.sqlserver.generator.Generator;

public class PriceGenerator extends Generator {
	private static Random random = new Random(System.currentTimeMillis());

	@Override
	public String get() {
		int length = this.data.size();
		return this.data.get(random.nextInt(length));
	}

	public String getCurrency() {
		return this.get();
	}

	public double getPrice() {
		String price = new DecimalFormat("#.00").format(random.nextDouble() * 3000);
		return Double.valueOf(price).doubleValue();
	}

}
