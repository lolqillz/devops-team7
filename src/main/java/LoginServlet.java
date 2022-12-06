

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dvops.maven.eclipse.User;
import com.dvops.maven.eclipse.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if (name.isEmpty() || password.isEmpty()) {
			request.setAttribute("login-output", "Please input your name and password");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		UserDAO userDao = new UserDAO();
		
		try {
			User user = userDao.checkLogin(name, password);
			String destPage = "login.jsp";
			
			if (user != null) {
				// request.setAttribute("login-output", java.text.MessageFormat.format("inputpass: {0} <br/> correctpass: {1}", password, user.getPassword()));
				if (password.equals(user.getPassword())) {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					destPage = "/UserServlet/dashboard";
				} else {
					request.setAttribute("login-output", "Incorrect password, please try again");
				}
				
			} else {
				request.setAttribute("login-output", "No such user");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			request.setAttribute("login-output", "user not or incorrect password");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
