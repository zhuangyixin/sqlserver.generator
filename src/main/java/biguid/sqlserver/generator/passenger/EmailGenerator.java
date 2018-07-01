package biguid.sqlserver.generator.passenger;

import java.util.Random;

import biguid.sqlserver.generator.Generator;

public class EmailGenerator extends Generator {

	private static Random domainRandom = new Random(System.currentTimeMillis());

	@Override
	public String get() {
		int index = domainRandom.nextInt(this.data.size());
		String emailSuffix = this.data.get(index);
		return emailSuffix;
	}

	public String getEmail(String surname, String givenName) {
		String emailSuffix = this.get();
		String email = String.format("%s.%s@%s", givenName, surname, emailSuffix);
		return email;
	}

}
