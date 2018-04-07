package biguid.sqlserver.generator.passenger;

import java.util.Iterator;

import biguid.sqlserver.generator.Generator;

public class NameGenerator extends Generator {

	private Iterator<String> iterator;

	public NameGenerator() {
		super();
		this.iterator = this.data.iterator();
	}

	@Override
	public String get() {
		String name = null;
		if (this.iterator.hasNext()) {
			name = this.iterator.next();
		}
		return name;
	}

	public int size() {
		return this.data.size();
	}
}
