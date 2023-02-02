package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	
	
	private User user;

	@BeforeEach
	void setUp() throws Exception {
		user = new User("Brian", "password", "Briantesting123@gmail.com", "English");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetName() {
		//fail("Not yet implemented");
		String expected = "Brian";
		String actual = user.getName();
		assertEquals(expected, actual);
	}
	
//	@Test
//	void testSetName() {
//		String expected = "Yoke";
//		user.setName(expected);
//		assertEquals(expected, user.getName());
//	}

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
		String expected = "Briantesting123@gmail.com";
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