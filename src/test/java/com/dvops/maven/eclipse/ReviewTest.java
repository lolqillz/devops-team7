package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReviewTest {
	Review review;

	@BeforeEach
	void setUp() throws Exception {
		review = new Review("Test", 01, 01, "Test Review");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetName() {
		//fail("Not yet implemented");
		String test = "Test";
		String actual = review.getName();
		assertEquals(test, actual);
	}

	@Test
	void testSetName() {
		//fail("Not yet implemented");
		String test = "Testing";
		review.setName(test);
		assertEquals(test, review.getName());
	}

	@Test
	void testGetId() {
		//fail("Not yet implemented");
		int test = 01;
		Number actual = review.getId();
		assertEquals(test, actual);
	}

	@Test
	void testSetId() {
		//fail("Not yet implemented");
		int test = 02;
		review.setId(test);
		assertEquals(test, review.getId());
	}

	@Test
	void testGetBook_id() {
		//fail("Not yet implemented");
		int test = 01;
		Number actual = review.getBook_id();
		assertEquals(test, actual);
	}

	@Test
	void testSetBook_id() {
		//fail("Not yet implemented");
		int test = 02;
		review.setBook_id(test);
		assertEquals(test, review.getBook_id());
		
	}

	@Test
	void testGetReview() {
		//fail("Not yet implemented");
		String test = "Test Review";
		String actual = review.getReview();
		assertEquals(test, actual);
	}

	@Test
	void testSetReview() {
		//fail("Not yet implemented");
		String test = "Change test review";
		review.setReview(test);
		assertEquals(test, review.getReview());
	}

}
