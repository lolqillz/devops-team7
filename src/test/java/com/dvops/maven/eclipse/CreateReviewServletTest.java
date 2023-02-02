package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;
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

class CreateReviewServletTest {
	private StringWriter stringWriter = new StringWriter();
	private PrintWriter printWriter = new PrintWriter(stringWriter);
	
	private Review review;

	@BeforeEach
	void setUp() throws Exception {
		review = new Review("name", 12345, 123, "Test");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testDoGet() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(response.getWriter()).thenReturn(printWriter);
		new CreateReviewServlet().doGet(request, response);	
	}

	@Test
	void testDoCreateReview() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(request.getParameter("name")).thenReturn(review.getName());
		when(request.getParameter("id")).thenReturn(review.getId().toString());
		when(request.getParameter("book_id")).thenReturn(review.getBook_id().toString());
		when(request.getParameter("review")).thenReturn(review.getReview());
		
		
		when(request.getRequestDispatcher("ReviewServlet")).thenReturn(rd);
		
		new CreateReviewServlet().doPost(request, response);		
	}

}