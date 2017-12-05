package prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import conn.ConnectionMngr;

public class InsertTest extends ConnectionMngr {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String insertTableSQL = "INSERT INTO jdbc_test(NAME, AGE) VALUES(?, ?)";
		try (Connection conn = getConnection("jdbc:mysql://localhost:3306/mysql", "root", "111111");
				PreparedStatement stmt =  conn.prepareStatement(insertTableSQL)) {

			stmt.setString(1, "userfile");
			stmt.setInt(2, 30);
			int n = stmt.executeUpdate();
			System.out.println("Updated rows:" + n ) ;
		}
	}

}
