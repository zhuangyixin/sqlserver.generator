package biguid.sqlserver.utils;

import biguid.sqlserver.data.passenger.Email;
import biguid.sqlserver.data.passenger.Name;
import biguid.sqlserver.data.passenger.Passport;
import biguid.sqlserver.data.passenger.Phone;
import biguid.sqlserver.data.passenger.Sex;
import biguid.sqlserver.model.Passenger;

public class PassengerGenerator {
	private Name surname;
	private Name givenName;
	private Sex sex;
	private Passport passport;
	private Email email;
	private Phone phone;

	public Passenger generate() {
		Passenger passenger = new Passenger();
		passenger.setSurname(surname.get());
		passenger.setGivenName(givenName.get());
		passenger.setSex(sex.get());
		passenger.setPassport(passport.get());
		passenger.setEmail(email.get());
		passenger.setPhone(phone.get());
		return passenger;
	}
}
