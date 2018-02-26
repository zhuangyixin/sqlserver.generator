package biguid.sqlserver.script;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMessage {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogMessage.class);

	public static void main(String[] args) {
		LOGGER.info("Test log message.");
	}
}
