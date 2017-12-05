package op;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import conn.ConnectionMngr;

public class UpdateTest extends ConnectionMngr {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try (Connection conn = getConnection("jdbc:mysql://localhost:3306/mysql", "root", "111111");
				Statement stmt = conn.createStatement()) {

			String updateTableSQL = "UPDATE jdbc_test"
					+ " SET NAME = 'appliction' WHERE AGE = 1" ;		
			
			int n = stmt.executeUpdate(updateTableSQL);
			System.out.println("Updated rows:" + n ) ;
		}
	}

}
