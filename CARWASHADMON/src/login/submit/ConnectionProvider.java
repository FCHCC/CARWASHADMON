package login.submit;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Myprovider {
	
	static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection(url,login,password);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return conn;
	}
}
