package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReviewTest {
	
	Review review;

	@BeforeEach
	void setUp() throws Exception {
		review = new Review("name", 12345, 123, "Test");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetName() {
		//fail("Not yet implemented");
		String expected = "name";
		String actual = review.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testGetId() {
		//fail("Not yet implemented");
		int expected = 12345;
		int actual = (int) review.getId();
		assertEquals(expected, actual);
	}

	@Test
	void testGetBookID() {
		//fail("Not yet implemented");
		int expected = 123;
		int actual = (int) review.getBook_id();
		assertEquals(expected, actual);
	}

	@Test
	void testGetReview() {
		//fail("Not yet implemented");
		String expected = "Test";
		String actual = review.getReview();
		assertEquals(expected, actual);
	}
}