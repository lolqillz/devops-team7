/**
 * 
 */
package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @author joelk
 *
 */
class RegisterServletTest {
	private StringWriter stringWriter = new StringWriter();
	private PrintWriter printWriter = new PrintWriter(stringWriter);
	
	private User user;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		user = new User("Albert", "password", "joelkohmuikiang@gmail.com", "English");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link RegisterServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testDoPostHttpServletRequestHttpServletResponse() throws Exception {
		//fail("Not yet implemented");
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(request.getParameter("userName")).thenReturn("Albert Gae");
		when(request.getParameter("password")).thenReturn(user.getPassword());
		when(request.getParameter("email")).thenReturn(user.getEmail());
		when(request.getParameter("language")).thenReturn(user.getLanguage());
		
		when(request.getRequestDispatcher(eq("/register.jsp"))).thenReturn(rd);
		
		new RegisterServlet().doPost(request, response);
		
		System.out.println(user.getName());
	}

}