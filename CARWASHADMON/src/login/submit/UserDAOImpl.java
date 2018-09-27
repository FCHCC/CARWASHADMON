package login.submit;

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
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getName());
			
			status=ps.executeUpdate();
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public User getUser(String userId, String password) {
		User u = new User();
		
		try {
			conn = ConnectionProvider.getConnection();
			ps= conn.prepareStatement("select * from Users where Username=? and Password=?");
			ps.setString(1,userId );
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setName(rs.getString(3));
			}
			
			conn.close();
			
		}catch(Exception e){
			
			System.out.println(e);
		}
		return u;
	}

}
