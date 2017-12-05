import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class URLClassLoaderDemo {
	private static Connection conn;

	public static Connection getConn(String url,String user, String pass)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException
	{
		if (conn == null)
		{
			URL[] urls = {new URL("file:./lib/mysql-connector-java-5.1.45.jar")};
			URLClassLoader myClassLoader = new URLClassLoader(urls);
			
			Driver driver = (Driver)myClassLoader.loadClass("com.mysql.jdbc.Driver").newInstance();

			Properties props = new Properties();
			props.setProperty("user" , user);
			props.setProperty("password" , pass);
			conn = driver.connect(url , props);
			myClassLoader.close(); // !!!!
		}
		return conn;
	}
	public static void main(String[] args)throws Exception
	{
		System.out.println(getConn("jdbc:mysql://localhost:3306/mysql", "root" , "111111"));
	}
}
