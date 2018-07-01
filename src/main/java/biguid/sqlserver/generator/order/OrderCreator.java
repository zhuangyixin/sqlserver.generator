package biguid.sqlserver.generator.order;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import biguid.sqlserver.model.Order;

public class OrderCreator {
	private static AirportGenerator airportGenerator = new AirportGenerator();
	private static PaymentGenerator paymentGenerator = new PaymentGenerator();
	private static PriceGenerator priceGenerator = new PriceGenerator();
	private static UIDGenerator uidGenerator = new UIDGenerator();
	private static AirlineGenerator airlineGenerator = new AirlineGenerator();
	private static Random random = new Random(System.currentTimeMillis());

	public static Order create() {
		Order order = new Order();
		order.setAirline(airlineGenerator.get());
		order.setCard_number(paymentGenerator.getCardNumber());
		order.setCvv(paymentGenerator.getCVV());
		order.setCurrency(priceGenerator.getCurrency());
		order.setPrice(priceGenerator.getPrice());
		String departureAirport = airportGenerator.getDepartureAirport();
		String arrivalAirport = airportGenerator.getArrivalAirport(departureAirport);
		order.setDepartureAirport(departureAirport);
		order.setArrivalAirport(arrivalAirport);
		Date departureDate = DateGenerator.getDepartureDate();
		Date arrivalDate = DateGenerator.getArrivalDate(departureDate);
		order.setDepartureDate(departureDate);
		order.setArrivalDate(arrivalDate);
		order.setFlightNumber(String.format("%04d", random.nextInt(10000)));
		order.setPassenger((long) random.nextInt(40602));
		order.setOrderID(UUID.randomUUID().toString());
		order.setUID(uidGenerator.get());
		return order;
	}
}
