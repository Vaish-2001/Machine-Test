package machinetest;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class LoginJourney  {

	@Parameters({ "Email", "Password" })
	@Test(priority = 0)
	public void signup(String email, String password) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		// Maximizing the window
		driver.manage().window().maximize();
		// Providing waiting condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Entering into the web site
		driver.get("https://testffc.nimapinfotech.com/");

		String expected_email = "siddiqshaikh1@nimapinfotech.com";
		String expected_password = "admin@123";
		// Validating the email and password using Assert class
		Assert.assertEquals(expected_email, email, "*** Email is IN-VALID ***");
		// Printing the message in the console using Reporter class
		Reporter.log("*** Email is VALID ***", true);
		Assert.assertEquals(expected_password, password, "*** Password is IN-VALID ***");
		Reporter.log("*** Password is VALID ***", true);
		// Passing the parameterised email and password variables in the text field respectively
		driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
		/*
		 * Creating the object of scanner class to take the input from the user manually
		 * of the captcha because it can't be automated
		 */
		Scanner sc = new Scanner(System.in);
		// Entering the value of captcha in the console
		System.out.print("ENTER THE CAPTCHA : ");
		String captcha = sc.next();
		System.out.println();
		// Finding the captcha textfield to the manual data
		driver.findElement(By.xpath("//input[@formcontrolname='captchaValue']")).sendKeys(captcha);
		Thread.sleep(3000);
		// clicking on sign in button
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
