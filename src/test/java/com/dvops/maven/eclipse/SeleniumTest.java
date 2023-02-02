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
		public void checkRegisterTitle() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/register.jsp");
			assertEquals(webDriver.getTitle(),"Register Deployment");
			System.out.println("title: " + webDriver.getTitle());
			
		}
		
		@Test
		public void checkRegisterId() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/register.jsp");
			WebElement we = webDriver.findElement(By.id("form-content"));
			System.out.println("Id WebElement: " + we.getAttribute("role"));
			assertEquals(we.getAttribute("role"), "registerform");
		}
		
		@Test
		public void checkLoginTitle() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/login.jsp");
			assertEquals(webDriver.getTitle(), "Login");
			System.out.println("title: " + webDriver.getTitle());
			
		}
		
		@Test
		public void checkLoginId() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/login.jsp");
			WebElement we = webDriver.findElement(By.id("form-content"));
			System.out.println("Id WebElement: " + we.getAttribute("role"));
			assertEquals(we.getAttribute("role"), "loginform");
		}
		
		@Test
		public void checkReviewManagementTitle() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/ReviewServlet");
			assertEquals(webDriver.getTitle(), "Review Management");
			System.out.println("title: " + webDriver.getTitle());
		
		}
		
		@Test
		public void checkReviewManagementId() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/ReviewServlet");
			WebElement we = webDriver.findElement(By.id("reviewTable"));
			System.out.println("Id WebElement: " + we.getAttribute("role"));
			assertEquals(we.getAttribute("role"), "reviewList");
		}
		
		@Test
		public void checkCreateReviewFormTitle() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/create_review.jsp");
			assertEquals(webDriver.getTitle(), "Create Review Form");
			System.out.println("title: " + webDriver.getTitle());
		}
		
		@Test
		public void checkCreateReviewFormId() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/create_review.jsp");
			WebElement we = webDriver.findElement(By.id("form-content"));
			System.out.println("Id WebElement: " + we.getAttribute("role"));
			assertEquals(we.getAttribute("role"), "createReviewForm");
		}
		
		@Test
		public void checkUserManagementTitle() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/userManagement.jsp");
			assertEquals(webDriver.getTitle(), "Test");
			System.out.println("title: " + webDriver.getTitle());
			webDriver.findElement(By.className("btn-success")).click();
			assertTrue(webDriver.getTitle().contains("Register Deployment"));
			System.out.println("New Title: " + webDriver.getTitle());
		}
		
		@Test
		public void checkUserManagementId() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/userManagement.jsp");
			WebElement we = webDriver.findElement(By.id("userTable"));
			System.out.println("Id WebElement: " + we.getAttribute("role"));
			assertEquals(we.getAttribute("role"), "userList");
		}
		
		@Test
		public void checkIndexTitle() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/index.jsp");
			assertEquals(webDriver.getTitle(), "Index");
			System.out.println("title: " + webDriver.getTitle());
		}
		
		@Test
		public void checkIndexId() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/index.jsp");
			WebElement we = webDriver.findElement(By.id("form-content"));
			System.out.println("Id WebElement: " + we.getAttribute("role"));
			assertEquals(we.getAttribute("role"), "indexform");
		}
		
		@Test
		public void checkUserEditTest() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/userEdit.jsp");
			assertEquals(webDriver.getTitle(), "User Management Application");
			System.out.println("title: " + webDriver.getTitle());
			webDriver.findElement(By.className("nav-link")).click();
			assertTrue(webDriver.getTitle().contains("Test"));
			System.out.println("New Title: " + webDriver.getTitle());
		}
		
		@Test
		public void checkUserEditId() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/userEdit.jsp");
			WebElement we = webDriver.findElement(By.id("user-edits"));
			System.out.println("Id WebElement: " + we.getAttribute("role"));
			assertEquals(we.getAttribute("role"), "editForms");
		}
		
		@Test
		public void checkUserEditTitle() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/userEdit.jsp");
			
			System.out.println("title: " + webDriver.getTitle());
			assertEquals(webDriver.getTitle(), "User Management Application");
		}
		
		@Test
		public void checkCommentManagementTitle() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/CommentServlet");
			assertEquals(webDriver.getTitle(), "Comment Management");
			System.out.println("title: " + webDriver.getTitle());
			webDriver.findElement(By.className("btn-success")).click();
			
			System.out.println("New Title: " + webDriver.getTitle());
			assertTrue(webDriver.getTitle().contains("Create Comment Form"));
		}
		@Test
		public void checkCreateCommentTitle() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/create_comment.jsp");
			
			System.out.println("title: " + webDriver.getTitle());
			assertEquals(webDriver.getTitle(), "Create Comment Form");
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
			
			System.out.println("title: " + webDriver.getTitle());
			assertEquals(webDriver.getTitle(), "Create Comment Form");
		}
		
		@Test
		public void checkCreateCommentFormId() {
			webDriver.navigate().to("http://localhost:8090/HelloWorldJavaEE/create_comment.jsp");
			WebElement we = webDriver.findElement(By.id("form-content"));
			System.out.println("Id WebElement: " + we.getAttribute("role"));
			assertEquals(we.getAttribute("role"), "createCommentForm");
		}


	}