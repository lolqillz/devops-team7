

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dvops.maven.eclipse.Comment;





/**
 * Servlet implementation class CommentingServet
 */
@WebServlet("/CommentingServet")
public class CommentingServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/usercomment";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	private static final String INSERT_COMMENTS_SQL = "INSERT INTO USERCOMMENTS" + " (name,comment) VALUES " +
			" (?, ?);";
			private static final String SELECT_COMMENTS = "select * from usercomment";
			private static final String SELECT_ALL_COMMENTS = "select * from usercomment ";
			private static final String DELETE_COMMENTS_SQL = "delete from usercomments where name = ?;";
			private static final String UPDATE_COMMENTS_SQL = "update usercomments set name = ?,comment= ? where name = ?;";
			
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
    public CommentingServet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		
		try {
			switch (action) {
				case "/insert":
					break;
				case "/delete":
					break;
				case "/edit":
					break;
				case "/update":
					break;
				default:
					listComments(request, response);
					break;
			}
			} catch (SQLException ex) {
				throw new ServletException(ex);
				}
			}
		private void listComments(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException
		{
			List <Comment> comments = new ArrayList <>();
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement =
		connection.prepareStatement(SELECT_ALL_COMMENTS);) {
					ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					String name = rs.getString("name");
					String comment = rs.getString("comment");
					
					comments.add(new Comment(name, comment));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		request.setAttribute("listComments", comments);
		
		request.getRequestDispatcher("/usermanagement.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}