package login.submit;

public interface UserDAO {

		public int insertUser(User u);
		public User getUser(String userName, String password);
}
