package biguid.sqlserver.generator.order;

import java.util.Random;

import biguid.sqlserver.generator.Generator;

public class AirlineGenerator extends Generator {
	private static final Random random = new Random(System.currentTimeMillis());

	@Override
	public String get() {
		int length = this.data.size();
		return this.data.get(random.nextInt(length));
	}

}
