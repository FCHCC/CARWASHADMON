package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {
	
	static Connection conn;
	static PreparedStatement ps;
	
	@Override
	public int insertUser(User u) {
		int status=0;
		
		try {
			conn=ConnectionProvider.getConnection();
			ps= conn.prepareStatement("insert into Users values(?,?)");
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getName());
			
			status=ps.executeUpdate();
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public User getUser(String Username, String password) {
		User u = new User();
		
		try {
			conn = ConnectionProvider.getConnection();
			System.out.println("success"+conn);
			ps= conn.prepareStatement("select * from Users where Username=? and Password=?");
			ps.setString(1,Username );
			ps.setString(2, password);
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setName(rs.getString(4));
				
			}
			
			
			conn.close();
			
		}catch(Exception e){
			
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		return u;
	}

}
