package com.dvops.maven.eclipse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/commenting.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String n = request.getParameter("userName");
		String c = request.getParameter("comment");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/usercomments", "root", "password");
			PreparedStatement ps = con.prepareStatement("insert into COMMENTS values(?,?)");
			ps.setString(1, n);
			ps.setString(2, c);
			int i = ps.executeUpdate();
			if (i > 0){
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "You have successfully commented!" +
				"</h1>");
				writer.close();
				}
				}
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
			}
			doGet(request, response);
		doGet(request, response);
		
	}
	

}
