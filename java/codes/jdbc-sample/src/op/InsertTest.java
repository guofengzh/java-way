package op;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import conn.ConnectionMngr;

public class InsertTest extends ConnectionMngr {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try (Connection conn = getConnection("jdbc:mysql://localhost:3306/mysql", "root", "111111");
				Statement stmt = conn.createStatement()) {

			String insertTableSQL = "INSERT INTO jdbc_test(NAME, AGE) VALUES('system', 1)";
			int n = stmt.executeUpdate(insertTableSQL);
			System.out.println("Updated rows:" + n ) ;
		}
	}

}
