package com.dvops.maven.eclipse;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvops.maven.eclipse.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/devops";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	private static final String INSERT_USERS_SQL = "INSERT INTO userinformation" + "(name, password, email, language) VALUES" + "(?,?,?);";
	private static final String SELECT_USER_BY_ID = "select name, password, email, language from userinformation where name=?";
	private static final String SELECT_ALL_USERS = "select * from userinformation";
	private static final String DELETE_USERS_SQL = "delete from userinformation where name = ?;";
	private static final String UPDATE_USERS_SQL = "update userinformation set name = ?, password = ?, email = ?, language = ? where name = ?;";
	
	//Step 3: Implement the getConnection method which facilitates connection to the database via JDBC
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			return connection;
		}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 4: Depending on the request servlet path, determine the function to invoke using the following switch statement
		String action = request.getServletPath();
						try {
					switch (action) {
						case "/UserServlet/delete":
							deleteUser(request, response);
							break;
						case "/UserServlet/edit":
							showEditForm(request, response);
							break;
						case "/UserServlet/update":
							updateUser(request, response);
							break;
						case "/UserServlet/dashboard":
							listUsers(request, response);
							break;
					}
				} catch (SQLException ex) {
					throw new ServletException(ex);
				}
	}
	
	private void listUsers(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException
	{
		List <User> users = new ArrayList <>();
		try (Connection connection  = getConnection();
				//Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			//Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			//Step 5.3: Process the ResultSet object
			while (rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String language = rs.getString("language");
				users.add(new User(name, password, email, language));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		//Step 5.4: Set the users list into the listUsers attribute to be pass to the userManagement.jsp
		request.setAttribute("listUsers", users);
		request.getRequestDispatcher("/userManagement.jsp").forward(request, response);
	}
	
	//method to get parameter, query database for existing user data and redirect to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
		//get parameter passed in the URL
		String name = request.getParameter("name");
		User existingUser = new User("", "", "", "");
		
		//Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				//Step 2: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
				preparedStatement.setString(1, name);
				
				//Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();
				
				//Step 4: Process the ResultSet object
				while (rs.next()) {
					name = rs.getString("name");
					String password = rs.getString("password");
					String email = rs.getString("email");
					String language = rs.getString("language");
					existingUser = new User(name, password, email, language);
				}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		//Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("user", existingUser);
		request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
	}
	
	//method to update the user table base on the form data
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
		//Step 1: Retrieve value from the request
		String oriName = request.getParameter("oriName");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String language = request.getParameter("language");
		
		//Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, name);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setString(4, language);
			statement.setString(5, oriName);
			
			int i = statement.executeUpdate();
		}
		//Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
		response.sendRedirect("http://localhost:8090/HelloWorldJavaEE/UserServlet/dashboard");
	}
	
	//method to delete user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
		//Step 1: Retrieve value from the request
		String name = request.getParameter("name");
		
		//Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, name);
			int i = statement.executeUpdate();
		}
		
		//Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
		response.sendRedirect("http://localhost:8090/HelloWorldJavaEE/UserServlet/dashboard");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
