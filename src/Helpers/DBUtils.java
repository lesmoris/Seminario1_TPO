package Helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	public static void closeQuietly(Connection con) {
		try { con.close(); } catch (Exception e) { /* ignored */ }
	}
	
	public static int getLastInsertedID(Connection con, String tableName) throws Exception {
		String senten = "select IDENT_CURRENT('" + tableName + "') as generatedId; ";
		PreparedStatement ps = con.prepareStatement(senten);
		ResultSet res = ps.executeQuery();
		res.next();
		int generatedKey = res.getInt("generatedId");
		return generatedKey;
	}
}
