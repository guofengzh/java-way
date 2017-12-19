package servlet.basic.listener;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private Driver dr ;
	private String url ;
	private Properties properties ;
	
    public ConnectionManager(String url, String user, String passwd ) {
    	try {
			dr = new com.mysql.jdbc.Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	this.url = url ;
        properties = new Properties();
        properties.put("user",user);
        properties.put("password", passwd);
    }
    public Connection getConnection() throws SQLException {
    	Connection con = dr. connect(url,properties);
        return con;
    }
}