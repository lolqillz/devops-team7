package com.dvops.maven.eclipse;

import java.sql.*;

public class CommentDAO {

	public Comment getComment(String name, String comment) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/usercomments";
		String jdbcUsername = "root";
		String jdbcPassword = "password";

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		String sql = "SELECT * FROM USERCOMMENTS ";
//		String sql = "SELECT * FROM userinformation WHERE name = ? and password = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
//		preparedStatement.setString(2, password);

		ResultSet result = preparedStatement.executeQuery();

		Comment comments = null;

		if (result.next()) {
			comments = new Comment(result.getString("name"), result.getString("comment"));
		}
		connection.close();
		return comments;
	}
}
