package biguid.sqlserver.generator.passenger;

import java.util.Random;

import biguid.sqlserver.generator.Generator;

public class EmailGenerator extends Generator {

	private static Random domainRandom = new Random(System.currentTimeMillis());
	private String surname;
	private String givenName;

	public EmailGenerator(String surname, String givenName) {
		this.surname = surname;
		this.givenName = givenName;
	}

	@Override
	public String get() {
		int index = domainRandom.nextInt(this.data.size());
		String emailSuffix = this.data.get(index);
		String email = String.format("%s.%s@%s", this.givenName, this.surname, emailSuffix);
		return email;
	}

}
