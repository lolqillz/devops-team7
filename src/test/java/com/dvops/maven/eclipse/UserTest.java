package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	
	//User user = new User ("Joel Koh Mui Kiang", "password", "joelkohmuikiang@gmail.com", "English");
	private User user;

	@BeforeEach
	void setUp() throws Exception {
		user = new User("Albert", "password", "joelkohmuikiang@gmail.com", "English");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetName() {
		//fail("Not yet implemented");
		String expected = "Albert";
		String actual = user.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testGetPassword() {
		//fail("Not yet implemented");
		String expected = "password";
		String actual = user.getPassword();
		assertEquals(expected, actual);
	}

	@Test
	void testGetEmail() {
		//fail("Not yet implemented");
		String expected = "joelkohmuikiang@gmail.com";
		String actual = user.getEmail();
		assertEquals(expected, actual);
	}

	@Test
	void testGetLanguage() {
		//fail("Not yet implemented");
		String expected = "English";
		String actual = user.getLanguage();
		assertEquals(expected, actual);
	}

}
