package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServletTest {
	private String jdbcURL = "jdbc:mysql://localhost:3306/devops";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetConnection() throws Exception{
		new UserServlet().getConnection();
	}

	@Test
	void testShowEditForm() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		String url = "/UserServlet/edit";

		when(request.getParameter("name")).thenReturn("Hadi");
		
		when(request.getRequestDispatcher(eq("/userEdit.jsp"))).thenReturn(rd);
		when(request.getServletPath()).thenReturn(url);
		new UserServlet().doPost(request, response);
	}

	@Test
	void testDeleteUser() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		String url = "/UserServlet/delete";
		
		when(request.getParameter("name")).thenReturn("Albert");
		
		when(request.getServletPath()).thenReturn(url);
		new UserServlet().doPost(request, response);
	}

	@Test
	void testUpdateUser() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		String url = "/UserServlet/update";

		when(request.getParameter("oriName")).thenReturn("Hadi");
		when(request.getParameter("name")).thenReturn("Hadi");
		when(request.getParameter("password")).thenReturn("password");
		when(request.getParameter("email")).thenReturn("hadi@gmail.com");
		when(request.getParameter("language")).thenReturn("English");
		
		when(request.getServletPath()).thenReturn(url);
		new UserServlet().doPost(request, response);
	}

	@Test
	void testListUser() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		String url = "/UserServlet/dashboard";
		
		when(request.getRequestDispatcher(eq("/userManagement.jsp"))).thenReturn(rd);
		when(request.getServletPath()).thenReturn(url);
		new UserServlet().doPost(request, response);
	}

}
