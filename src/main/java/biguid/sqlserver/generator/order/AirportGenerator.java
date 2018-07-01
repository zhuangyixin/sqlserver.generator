package biguid.sqlserver.generator.order;

import java.util.Random;

import biguid.sqlserver.generator.Generator;

public class AirportGenerator extends Generator {
	private static Random indexRandom = new Random(System.currentTimeMillis());

	@Override
	public String get() {
		int index = indexRandom.nextInt(this.data.size());
		return this.data.get(index);
	}

	public String getDepartureAirport() {
		return this.get();
	}

	public String getArrivalAirport(String departureAirport) {
		String arrivalAirport = this.get();
		while (arrivalAirport.equals(departureAirport)) {
			arrivalAirport = this.get();
		}
		return arrivalAirport;
	}

}
