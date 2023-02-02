package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginServletTest {
	private StringWriter stringWriter = new StringWriter();
	private PrintWriter printWriter = new PrintWriter(stringWriter);
	
	private User user;

	@BeforeEach
	void setUp() throws Exception {
		user = new User("Brian", "password", "Brian1234@gmail.com", "English");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testDoGet() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(request.getRequestDispatcher(("/login.jsp"))).thenReturn(rd);
		new LoginServlet().doGet(request, response);
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() throws Exception {

		//fail("Not yet implemented");
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getParameter("name")).thenReturn("Brian");
		when(request.getParameter("password")).thenReturn("password");
		when(request.getSession()).thenReturn(session);
		doNothing().when(session).setAttribute("user", user);
		when(request.getRequestDispatcher(eq("ReviewServlet"))).thenReturn(rd);
		
		
		when(request.getRequestDispatcher(("/login.jsp"))).thenReturn(rd);
		
		new LoginServlet().doPost(request, response);
		
		System.out.println(user.getName());
	}

}