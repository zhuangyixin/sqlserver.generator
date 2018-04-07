package biguid.sqlserver.generator.order;

import java.util.Random;
import java.util.UUID;

import biguid.sqlserver.generator.Generator;

public class UIDGenerator extends Generator {
	private static Random indexRandom = new Random(System.currentTimeMillis());
	private static Random percentRandom = new Random(System.currentTimeMillis());

	@Override
	public String get() {
		int percent = percentRandom.nextInt(100);
		String uid = null;
		if (percent < 20) {
			int index = indexRandom.nextInt(this.data.size());
			uid = this.data.get(index);
		} else {
			uid = UUID.randomUUID().toString();
		}
		return uid;
	}
}
