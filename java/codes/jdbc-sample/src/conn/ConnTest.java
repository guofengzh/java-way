package conn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnTest extends ConnectionMngr {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try (Connection conn = getConnection("jdbc:mysql://localhost:3306/mysql", "root", "111111");
				Statement stmt = conn.createStatement()) {

			String sql = "select name from jdbc_test";
			boolean hasResultSet = stmt.execute(sql);

			if (hasResultSet) {
				try (ResultSet rs = stmt.getResultSet()) {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					while (rs.next()) {
						for (int i = 0; i < columnCount; i++) {
							System.out.print(rs.getString(i + 1) + "\t");
						}
						System.out.print("\n");
					}
				}
			} else {
				System.out.println("该SQL语句影响的记录有" + stmt.getUpdateCount() + "条");
			}

		}
	}

}
