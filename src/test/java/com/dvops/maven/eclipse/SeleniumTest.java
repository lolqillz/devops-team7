package com.dvops.maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumTest {
	
	static WebDriver webDriver;
	
	@AfterAll
	static public void afterTest() {
		webDriver.quit();
	}

	@BeforeAll
	static public void beforeTest() {
		String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver" , chromeDriverDir);
		webDriver = new ChromeDriver();
	}

	
	
	@Test
	public void checkCommentManagementTitle() {
		webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/CommentServlet");
		assertEquals(webDriver.getTitle(), "Comment Management");
		System.out.println("title: " + webDriver.getTitle());
		webDriver.findElement(By.className("btn-success")).click();
		assertTrue(webDriver.getTitle().contains("Create Comment Form"));
		System.out.println("New Title: " + webDriver.getTitle());
	}
	
	@Test
	public void checkCommentManagementId() {
		webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/CommentServlet");
		WebElement we = webDriver.findElement(By.id("commentTable"));
		System.out.println("Id WebElement: " + we.getAttribute("role"));
		assertEquals(we.getAttribute("role"), "commentList");
	}
	
	@Test
	public void checkCreateCommentFormTitle() {
		webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/create_comment.jsp");
		assertEquals(webDriver.getTitle(), "Create Comment Form");
		System.out.println("title: " + webDriver.getTitle());
	}
	
	@Test
	public void checkCreateCommentFormId() {
		webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/create_comment.jsp");
		WebElement we = webDriver.findElement(By.id("form-content"));
		System.out.println("Id WebElement: " + we.getAttribute("role"));
		assertEquals(we.getAttribute("role"), "createCommentForm");
	}
	
	
	@Test
	public void checkIndexTitle() {
		webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/index.jsp");
		assertEquals(webDriver.getTitle(), "Insert title here");
		System.out.println("title: " + webDriver.getTitle());
	}
}
/*	@Test
	public void checkIndexId() {
		webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/index.jsp");
		WebElement we = webDriver.findElement(By.id("form-content"));
		System.out.println("Id WebElement: " + we.getAttribute("role"));
		assertEquals(we.getAttribute("role"), "indexform");
	}
}
	*/

	