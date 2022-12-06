package com.dvops.maven.eclipse;

import java.sql.*;

public class UserDAO {
	
	public User checkLogin(String name, String password) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/devops";
		String jdbcUsername = "root";
		String jdbcPassword = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		String sql = "SELECT * FROM userinformation WHERE name = ?";
//		String sql = "SELECT * FROM userinformation WHERE name = ? and password = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
//		preparedStatement.setString(2, password);
		
		ResultSet result = preparedStatement.executeQuery();
		
		User user = null;
		
		if (result.next()) {
			user = new User(result.getString("name"), result.getString("password"), result.getString("email"), result.getString("language"));
			//user.setName(result.getString("name"));
		}
		connection.close();
		return user;
	}
}
