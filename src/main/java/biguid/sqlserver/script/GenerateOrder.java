package biguid.sqlserver.script;

import biguid.sqlserver.database.FlightDatabase;
import biguid.sqlserver.generator.order.OrderCreator;
import biguid.sqlserver.model.Order;

public class GenerateOrder {
	private static final int SIZE = 12000000;
	private static final int UNIT = 12000000 / 100;

	public static void main(String[] args) {

		FlightDatabase database = new FlightDatabase();
		database.connect();
		for (int i = 0; i < SIZE; i++) {
			Order order = OrderCreator.create();
			database.insertOrder(order);
			if (i % UNIT == 0) {
				System.out.println("Process data: " + i / UNIT + "%");
			}
		}
		database.disconnect();
	}
}
