package biguid.sqlserver.utils;

import biguid.sqlserver.generator.passenger.EmailGenerator;
import biguid.sqlserver.generator.passenger.PassportGenerator;
import biguid.sqlserver.generator.passenger.PhoneGenerator;
import biguid.sqlserver.generator.passenger.SexGeneartor;
import biguid.sqlserver.model.Passenger;

public class PassengerGenerator {

	private static SexGeneartor sexGenerator = new SexGeneartor();
	private static PassportGenerator passportGenerator = new PassportGenerator();
	private static PhoneGenerator phoneGenerartor = new PhoneGenerator();

	public static Passenger create(String surname, String givenName) {
		EmailGenerator emailGenerator = new EmailGenerator(surname, givenName);
		Passenger passenger = new Passenger();
		passenger.setEmail(emailGenerator.get());
		passenger.setGivenName(givenName);
		passenger.setSurname(surname);
		passenger.setPassport(passportGenerator.get());
		passenger.setPhone(phoneGenerartor.get());
		passenger.setSex(sexGenerator.get());
		return passenger;
	}

}