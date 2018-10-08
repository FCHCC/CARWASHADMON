package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRegister() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDAO ud = new UserDAOImpl();
		
		String userName = request.getParameter("Username");
		String password = request.getParameter("password");
		String submitType = request.getParameter("submit");
		
		User u = new User();
		u=ud.getUser(userName, password);
		
		System.out.println("Username"+u.getUsername()+"password"+u.getPassword()+"name"+u.getName());
		if(submitType.equals("Login") && u!=null && u.getName()!=null ) {
			
			request.setAttribute("message", u.getName());
			request.getRequestDispatcher("mainPage.jsp").forward(request, response);;
			
			
		}else {
			request.setAttribute("message", "DATA NOT FOUND TRY AGAIN");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	
	}

}
