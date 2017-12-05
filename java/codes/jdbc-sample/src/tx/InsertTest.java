package tx;

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
		
		String updateTableSQL = "UPDATE jdbc_test SET NAME =? WHERE AGE = ?";
		
		try (Connection dbConnection = getConnection("jdbc:mysql://localhost:3306/mysql", "root", "111111");
				PreparedStatement preparedStatementInsert = dbConnection.prepareStatement(insertTableSQL);
				PreparedStatement preparedStatementUpdate = dbConnection.prepareStatement(updateTableSQL)) {

			dbConnection.setAutoCommit(false); //transaction block start
			
			preparedStatementInsert.setString(1, "beijing");
			preparedStatementInsert.setInt(2, 99);
			preparedStatementInsert.executeUpdate(); //data IS NOT commit yet
			
			preparedStatementUpdate.setString(1, "A very very long string");
			preparedStatementUpdate.setInt(2, 9);
			preparedStatementUpdate.executeUpdate(); //Error, rollback, including the first insert statement.			
			
			dbConnection.commit(); //transaction block end
		}
	}
}
