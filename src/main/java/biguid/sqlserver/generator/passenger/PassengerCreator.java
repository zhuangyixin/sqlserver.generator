package biguid.sqlserver.generator.passenger;

import biguid.sqlserver.model.Passenger;

public class PassengerCreator {

	private static SexGeneartor sexGenerator = new SexGeneartor();
	private static PassportGenerator passportGenerator = new PassportGenerator();
	private static PhoneGenerator phoneGenerartor = new PhoneGenerator();
	private static EmailGenerator emailGenerator = new EmailGenerator();

	public static Passenger create(String surname, String givenName) {
		Passenger passenger = new Passenger();
		passenger.setEmail(emailGenerator.getEmail(surname, givenName));
		passenger.setGivenName(givenName);
		passenger.setSurname(surname);
		passenger.setPassport(passportGenerator.get());
		passenger.setPhone(phoneGenerartor.get());
		passenger.setSex(sexGenerator.get());
		return passenger;
	}

}