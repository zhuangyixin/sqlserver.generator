package biguid.sqlserver.script;

import java.sql.Connection;

import biguid.sqlserver.utils.SqlUtils;

public class GeneratePassenger {
	public static void main(String[] args) {

		SqlUtils sqlUtils = new SqlUtils();
		sqlUtils.connect();
		sqlUtils.disconnect();
	}
}
