package biguid.sqlserver.generator.order;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateGenerator {
	private static final Random random = new Random(System.currentTimeMillis());

	public static Date getDepartureDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, random.nextInt(360) - 180);
		calendar.set(Calendar.HOUR, random.nextInt(24));
		calendar.set(Calendar.MINUTE, random.nextInt(12) * 5);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getArrivalDate(Date departureDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(departureDate);
		calendar.add(Calendar.DATE, random.nextInt(7));
		calendar.set(Calendar.HOUR, random.nextInt(24));
		calendar.set(Calendar.MINUTE, random.nextInt(12) * 5);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
}
