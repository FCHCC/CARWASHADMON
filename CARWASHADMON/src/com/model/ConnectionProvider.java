package login;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Myprovider {
	
	static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection(url,login,password);
			System.out.println("success with connection");
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return conn;
	}
}
