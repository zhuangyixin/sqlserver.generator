package biguid.sqlserver.script;

import java.util.ArrayList;
import java.util.List;

import biguid.sqlserver.database.FlightDatabase;
import biguid.sqlserver.generator.passenger.NameGenerator;
import biguid.sqlserver.generator.passenger.PassengerCreator;
import biguid.sqlserver.model.Passenger;

public class GeneratePassenger {
	public static void main(String[] args) throws Exception {
		NameGenerator surnameGenerator = new NameGenerator();
		List<Passenger> passengerList = new ArrayList<Passenger>();

		FlightDatabase database = new FlightDatabase();
		database.connect();
		int size = surnameGenerator.size();
		for (int i = 0; i < size; i++) {
			String surname = surnameGenerator.get();
			NameGenerator givenNameGenerator = new NameGenerator();
			for (int j = 0; j < size; j++) {
				String givenName = givenNameGenerator.get();
				if (surname.equals(givenName)) {
					continue;
				}
				Passenger passenger = PassengerCreator.create(surname, givenName);
				passengerList.add(passenger);
				int count = database.insertPassenger(passenger);
				if (count <= 0) {
					throw new Exception();
				}
			}
		}
		database.disconnect();
	}
}
