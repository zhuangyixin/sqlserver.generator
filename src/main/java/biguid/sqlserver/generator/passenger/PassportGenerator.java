package biguid.sqlserver.generator.passenger;

import java.util.UUID;

import biguid.sqlserver.generator.Generator;

public class PassportGenerator extends Generator {

	@Override
	public String get() {
		String uuid = UUID.randomUUID().toString().toUpperCase();
		String[] uuidSplit = uuid.split("-");
		return uuidSplit[uuidSplit.length - 1];
	}

}
