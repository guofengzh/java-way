package prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import conn.ConnectionMngr;

public class SelTest extends ConnectionMngr {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String selectSQL = "SELECT NAME, AGE FROM jdbc_test WHERE AGE = ?";
		try (Connection conn = getConnection("jdbc:mysql://localhost:3306/mysql", "root", "111111");
				PreparedStatement stmt =  conn.prepareStatement(selectSQL)) {

			stmt.setInt(1, 1);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				System.out.println("name : " + name);
				System.out.println("age : " + age);

			}
		}
	}

}
