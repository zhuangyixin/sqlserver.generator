package biguid.sqlserver.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import biguid.sqlserver.model.Order;
import biguid.sqlserver.model.Passenger;

public class FlightDatabase {
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "zhuang513";
	private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433; DatabaseName=Flight";

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightDatabase.class);
	private static final String INSERT_PASSENGER = "INSERT INTO Flight.dbo.passenger"
			+ "	(surname, given_name, sex, passport, phone, email) VALUES (?,?,?,?,?,?)";

	private static final String INSERT_ORDER = "INSERT INTO Flight.dbo.orders "
			+ "(order_id, uid, airline, flight_number, departure_airport, "
			+ "arrival_airport, departure_datetime, arrival_datetime, price, currency, passenger, "
			+ "card_number, cvv) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private Connection connection;

	public void connect() {
		try {
			Class.forName(DRIVER_NAME);
			this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			LOGGER.info("Connect success");
		} catch (Exception ex) {
			LOGGER.error("Connect fail.");
			ex.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			this.connection.close();
			LOGGER.info("Disconnect Success");
		} catch (SQLException ex) {
			LOGGER.error("Connect fail.");
			ex.printStackTrace();
		}
	}

	public int insertPassenger(Passenger passenger) {
		PreparedStatement statement;
		try {
			statement = this.connection.prepareStatement(INSERT_PASSENGER);
			statement.setString(1, passenger.getSurname());
			statement.setString(2, passenger.getGivenName());
			statement.setString(3, passenger.getSex());
			statement.setString(4, passenger.getPassport());
			statement.setString(5, passenger.getPhone());
			statement.setString(6, passenger.getEmail());
			statement.execute();
			return statement.getUpdateCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insertOrder(Order order) {
		PreparedStatement statement;
		try {
			statement = this.connection.prepareStatement(INSERT_ORDER);
			statement.setString(1, order.getOrderID());
			statement.setString(2, order.getUID());
			statement.setString(3, order.getAirline());
			statement.setString(4, order.getFlightNumber());
			statement.setString(5, order.getDepartureAirport());
			statement.setString(6, order.getArrivalAirport());
			statement.setTimestamp(7, new Timestamp(order.getDepartureDate().getTime()));
			statement.setTimestamp(8, new Timestamp(order.getArrivalDate().getTime()));
			statement.setDouble(9, order.getPrice());
			statement.setString(10, order.getCurrency());
			statement.setLong(11, order.getPassenger());
			statement.setString(12, order.getCard_number());
			statement.setString(13, order.getCvv());
			statement.execute();
			return statement.getUpdateCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
