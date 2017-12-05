package op;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import conn.ConnectionMngr;

public class DeleteTest extends ConnectionMngr {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try (Connection conn = getConnection("jdbc:mysql://localhost:3306/mysql", "root", "111111");
				Statement stmt = conn.createStatement()) {

			String deleteTableSQL  = "DELETE from jdbc_test WHERE AGE = 5" ;			
			int n = stmt.executeUpdate(deleteTableSQL);
			System.out.println("Updated rows:" + n ) ;
		}
	}

}
