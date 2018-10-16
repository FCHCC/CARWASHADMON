package login;

public interface UserDAO {

		public int insertUser(User u);
		public User getUser(String userName, String password);
}
