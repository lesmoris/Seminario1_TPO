package Helpers;

import java.sql.Connection;

public class DBUtils {

	public static void closeQuietly(Connection con) {
		try { con.close(); } catch (Exception e) { /* ignored */ }
	}
}
