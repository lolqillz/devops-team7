package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommentTest {
	
	Comment comment;

	@BeforeEach
	void setUp() throws Exception {
		comment = new Comment("name", 3, "Testing");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetName() {
		//fail("Not yet implemented");
		String expected = "name";
		String actual = comment.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testGetId() {
		//fail("Not yet implemented");
		int expected = 3;
		int actual = (int) comment.getId();
		assertEquals(expected, actual);
	}


	@Test
	void testGetComment() {
		//fail("Not yet implemented");
		String expected = "Testing";
		String actual = comment.getComment();
		assertEquals(expected, actual);
	}
}
