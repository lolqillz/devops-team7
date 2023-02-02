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

class CreateCommentServletTest {
	private StringWriter stringWriter = new StringWriter();
	private PrintWriter printWriter = new PrintWriter(stringWriter);
	
	private Comment comment;

	@BeforeEach
	void setUp() throws Exception {
		comment = new Comment("name", 2, "Test comment");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testDoGet() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(response.getWriter()).thenReturn(printWriter);
		new CreateCommentServlet().doGet(request, response);	
	}

	@Test
	void testDoCreateComment() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);
		
		when(request.getParameter("name")).thenReturn(comment.getName());
		when(request.getParameter("id")).thenReturn(comment.getId().toString());
		when(request.getParameter("comment")).thenReturn(comment.getComment());
		
		
		when(request.getRequestDispatcher("CommentServlet")).thenReturn(rd);
		
	}

}