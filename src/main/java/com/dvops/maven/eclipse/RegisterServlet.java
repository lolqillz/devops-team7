package com.dvops.maven.eclipse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dvops.maven.eclipse.User;
import com.dvops.maven.eclipse.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n = request.getParameter("userName");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		String c = request.getParameter("language");
		
		if (n.isEmpty() || p.isEmpty() || e.isEmpty() || c.isEmpty()) {
			request.setAttribute("register-output", "Please input your information");
			request.getRequestDispatcher("/register.jsp").forward(request, response);			
			return;
		}
		
		User user = new User(n, p, e, c);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/devops", "root", "");
			
			PreparedStatement ps1 = con.prepareStatement("SELECT * FROM userinformation WHERE name = ?");
			ps1.setString(1, n);
			
			ResultSet result = ps1.executeQuery();
			if (result.next()) { 
				request.setAttribute("register-output", "Name already exists");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			}
			
			
//			if (n.equals(user.getName())){
//				request.setAttribute("register-output", "Name already exists");
//				request.getRequestDispatcher("/register.jsp").forward(request, response);
//				return;
//			} else {
//				PrintWriter writer = response.getWriter();
//				writer.println("<h1>" + "You have successfully registered an account!" + "<h1>");
//				writer.close();
//			}
			
			
			PreparedStatement ps = con.prepareStatement("insert into USERINFORMATION values(?,?,?,?)");
			
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.setString(4, c);
			
			int i = ps.executeUpdate();
			
			if (i > 0) {
				//request.getRequestDispatcher("/UserServlet/dashboard").forward(request, response);
				request.getRequestDispatcher("ReviewServlet").forward(request, response);
			}
			
			
		}
		catch (Exception exception) {
//			System.out.println(exception);
//			//comment out the next 2 lines
//		out.close();
		}
		doGet(request, response);
	}

}
