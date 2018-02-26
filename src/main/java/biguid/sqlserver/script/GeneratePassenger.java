package biguid.sqlserver.script;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import biguid.sqlserver.utils.FlightDatabase;

public class GeneratePassenger {
	private static final Logger LOGGER = LoggerFactory.getLogger(GeneratePassenger.class);
	public static void main(String[] args) {

		FlightDatabase flightDatabase = new FlightDatabase();
		flightDatabase.connect();
		LOGGER.info("Transaction");
		flightDatabase.disconnect();
	}
}
